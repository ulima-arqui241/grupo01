//
//  UserDefaults.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import Foundation

enum UserBasicAuthData: String {
    case accessToken = "accessToken"
    case refreshToken = "refreshToken"
}

extension UserDefaults {
    
    static func saveAuthData(field: UserBasicAuthData, value: Any) {
        UserDefaults.standard.setValue(value, forKey: field.rawValue)
    }
    
    static func getAccessToken() -> String? {
        return UserDefaults.standard.string(forKey: UserBasicAuthData.accessToken.rawValue)
    }
    
    static func getRefreshToken() -> String? {
        return UserDefaults.standard.string(forKey: UserBasicAuthData.refreshToken.rawValue)
    }
    
}
