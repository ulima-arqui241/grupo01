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
    
    func sendRequest<T>(request: URLRequest, responseType: T.Type) async throws -> T? where T: Decodable {
        
        let (data, response) = try await urlSession.data(for: request)
        
        guard let httpResponse = response as? HTTPURLResponse else {
            print("Unexpected response")
            return nil
        }
        
        if httpResponse.statusCode != 200 {
            print("Not 200 response, gotten: \(httpResponse.statusCode)")
            return nil
        }
        
        let dataJSON = try? JSONSerialization.jsonObject(with: data, options: [])
        if let dataJSON = dataJSON as? [String: Any] {
            print(dataJSON)
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
    
    func signUp(email: String, password: String) {
        print("SIGNUP: Username ( \(email) )")
        let parameters: [String: Any] = [
            "Username" : email,
            "Password" : password,
            "ClientId": clientId
        ]
        //        sendCognitoRequest(cognitoCase: .signUp, method: .post, parameters: parameters)
    }
    
    func changeAuthState(state: AuthenticationState) {
        withAnimation {
            self.authenticationState = state
        }
    }
}
