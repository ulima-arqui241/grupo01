//
//  CognitoResponse.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import Foundation

struct CognitoAuthResponse: Decodable {
    let authResult: AuthenticationResult
    
    enum CodingKeys: String, CodingKey {
        case AuthenticationResult
    }
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.authResult = try container.decode(AuthenticationResult.self, forKey: .AuthenticationResult)
    }
}

struct AuthenticationResult: Decodable {
    let accessToken: String
    let expirationSeconds: Int
    let tokenId: String
    let refreshToken: String
    let tokenType: String
    
    enum CodingKeys: String, CodingKey {
        case TokenType
        case RefreshToken
        case IdToken
        case ExpiresIn
        case AccessToken
    }
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.accessToken = try container.decode(String.self, forKey: .AccessToken)
        self.expirationSeconds = try container.decode(Int.self, forKey: .ExpiresIn)
        self.tokenId = try container.decode(String.self, forKey: .IdToken)
        self.tokenType = try container.decode(String.self, forKey: .TokenType)
        self.refreshToken = try container.decode(String.self, forKey: .RefreshToken)
    }
}

struct CognitoSignUpResponse: Decodable {
    var errorMessage: String? = nil
    var userConfirmed: Bool? = nil
    var userSub: String? = nil
    var codeDeliveryDetails: CodeDeliveryDetails? = nil
    
    enum CodingKeys: String, CodingKey {
        case CodeDeliveryDetails, UserConfirmed, UserSub, Message
    }
    
    init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.userSub = try? container.decode(String.self, forKey: .UserSub)
        self.codeDeliveryDetails = try? container.decode(CodeDeliveryDetails.self, forKey: .CodeDeliveryDetails)
        do {
            let userConfirmed = try container.decode(Bool.self, forKey: .UserConfirmed)
            self.userConfirmed = userConfirmed
        } catch {
            do {
                let message = try container.decode(String.self, forKey: .Message)
                self.errorMessage = message
            } catch {
                self.errorMessage = "Unable to decode \(error)"
            }
        }
     }
}

struct CodeDeliveryDetails: Decodable {
    let attributeName: String
    let deliveryMedium: String
    let destination: String
}

//
//{
//    "CodeDeliveryDetails": {
//        "AttributeName": "string",
//        "DeliveryMedium": "string",
//        "Destination": "string"
//    },
//    "UserConfirmed": boolean,
//    "UserSub": "string"
//}
