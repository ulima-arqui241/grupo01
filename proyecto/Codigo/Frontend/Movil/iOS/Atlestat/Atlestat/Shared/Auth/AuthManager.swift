//
//  AuthManager.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

enum AuthenticationState {
    case authenticated
    case register
    case nonAuthenticated
}

enum AWSCognitoCases: String {
    case signUp = "AWSCognitoIdentityProviderService.SignUp"
    case initiateAuth = "AWSCognitoIdentityProviderService.InitiateAuth"
    case verifyEmail = "AWSCognitoIdentityProviderService.ConfirmSignUp"
    
}
enum HTTPMethods: String {
    case get = "GET"
    case post = "POST"
}

@MainActor
//TODO: Abstract interfaces for interchangable auth providers
final class AuthenticationManager: ObservableObject {
    
    @Published var authenticationState: AuthenticationState = .nonAuthenticated
    
    private let cognitoUrl: URL = URL(string:"https://cognito-idp.us-east-1.amazonaws.com/")!
    private let clientId = "73flrg3fbgttftv5erolqe4g4g"
    
    private let urlSession = URLSession.shared
    
    init() {
//        let token = UserDefaults.getAccessToken()
//        if let token {
//            self.authenticationState = .authenticated
//        }
    }
    
    func buildCognitoRequest(cognitoCase: AWSCognitoCases, method: HTTPMethods, parameters: [String: Any]) -> URLRequest{
        var request = URLRequest(url: cognitoUrl)
        request.httpMethod = method.rawValue
        request.setValue(cognitoCase.rawValue, forHTTPHeaderField: "X-Amz-Target")
        request.setValue("application/x-amz-json-1.1", forHTTPHeaderField: "Content-Type")
        request.httpBody = try? JSONSerialization.data(withJSONObject: parameters)
        
        return request
    }
    
    func sendRequest(request: URLRequest) async throws -> Bool {
        let ( data , response) = try await urlSession.data(for: request)
        
        //Just to check
        let dataJSON = try? JSONSerialization.jsonObject(with: data, options: [])
        if let dataJSON = dataJSON as? [String: Any] {
            if let message = dataJSON["message"] {
                print(message)
                return false
            }
        }
        
        guard let httpResponse = response as? HTTPURLResponse else {
            print("Unexpected response")
            return false
        }
        
        return httpResponse.statusCode == 200
    }
    
    func sendRequest<T>(request: URLRequest, responseType: T.Type) async throws -> T? where T: Decodable {
        
        let (data, response) = try await urlSession.data(for: request)
        
        guard let httpResponse = response as? HTTPURLResponse else {
            print("Unexpected response")
            return nil
        }
        
        let dataJSON = try? JSONSerialization.jsonObject(with: data, options: [])
        if let dataJSON = dataJSON as? [String: Any] {
            print(dataJSON)
        }
        
        if httpResponse.statusCode != 200 {
            print("Not 200 response, gotten: \(httpResponse.statusCode)")
            return nil
        }
        
        let finalData = try JSONDecoder().decode(responseType.self, from: data)
        return finalData
    }
    
    func cognitoEmailLogin(email: String, password: String) async throws {
        print("login: Username ( \(email) )")
        let parameters: [String: Any] = [
            "AuthFlow": "USER_PASSWORD_AUTH",
            "AuthParameters": [
                "USERNAME" : email,
                "PASSWORD": password,
            ],
            "ClientId": clientId
        ]
        
        let request = buildCognitoRequest(cognitoCase: .initiateAuth, method: .post, parameters: parameters)
        
        do {
            let authData = try await sendRequest(request: request, responseType: CognitoAuthResponse.self)
            
            guard let authData else {
                print("No data")
                return
            }
            
            UserDefaults.saveAuthData(field: .accessToken, value: authData.authResult.accessToken)
            UserDefaults.saveAuthData(field: .refreshToken, value: authData.authResult.refreshToken)
            
            self.changeAuthState(state: .authenticated)
            
        } catch {
            print("Error", error)
        }
    }
    
    func cognitoSignUp(registerInfo: RegisterFinalInfo) async throws -> Bool {
        let parameters: [String: Any] = [
            "Username" : registerInfo.email,
            "Password" : registerInfo.password,
            "ClientId": clientId
//            "UserAttributes": [
//                [
//                    "name": "1",
//                    "value": [
//                        "name": "member",
//                        "value": [
//                            [
//                                "name": "name",
//                                "value": "Name"
//                            ],
//                            [
//                                "name": "email",
//                                "value": registerInfo.email
//                            ],
//                            
//                            [
//                                "name": "addresses",
//                                "value": registerInfo.step1Info.address
//                            ],
//                            [
//                                "name": "birthdate",
//                                "value": registerInfo.step1Info.birthDate
//                            ],
//                            [
//                                "name": "gender",
//                                "value": registerInfo.step1Info.gender
//                            ],
//                            [
//                                "name": "phoneNumbers",
//                                "value": registerInfo.step1Info.phoneNumber
//                            ],
//                            [
//                                "name": "givenName",
//                                "value": registerInfo.step1Info.givenNames
//                            ],
//                            [
//                                "name": "familyNames",
//                                "value": registerInfo.step1Info.familyNames
//                            ]
//                        ]
//                    ]
//                ],
//            ]
        ]
        let request = buildCognitoRequest(cognitoCase: .signUp, method: .post, parameters: parameters)
        
        let finalData = try await sendRequest(request: request)
        
        //Do some checks
        
        return true
    }
    
    func cognitoVerifyEmail(email: String, code: String) async throws -> Bool{
        let parameters: [String: Any] = [
            "ConfirmationCode": code,
            "Username": email,
            "ClientId": clientId
        ]
        
        let request = buildCognitoRequest(cognitoCase: .verifyEmail, method: .post, parameters: parameters)
        
        do {
            return try await sendRequest(request: request)
        } catch {
            print("Error", error)
            return false
        }
    }
    
    func changeAuthState(state: AuthenticationState) {
        withAnimation {
            self.authenticationState = state
        }
    }
}

struct CognitoAttribute: Codable {
    let name: String
    let value: String
}

//func verifyEmail(confirmationCode: String) -> String {
//    print("verifyEmail: Username ( \(email) )")
//    let parameters: [String: Any] = [
//        "ConfirmationCode": confirmationCode,
//        "Username": email,
//        "ClientId": clientId
//    ]
//    var retCode = waitForRequest(url: "AWSCognitoIdentityProviderService.ConfirmSignUp", method: "Post", parameters: parameters)
//    if (retCode) == "Success" {
//        retCode = login(email: email, password: password)
//    }
//    return retCode
//}
