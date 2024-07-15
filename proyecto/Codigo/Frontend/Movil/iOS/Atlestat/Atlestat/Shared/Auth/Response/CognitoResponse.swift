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
