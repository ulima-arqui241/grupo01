//
//  LoginIntent.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

protocol LoginIntentProtocol {
    func loginWithEmail(email: String, password: String) async
    func setAuthManager(_ manager: AuthenticationManager)
}

extension LoginView {
    final class Intent: LoginIntentProtocol {
        private weak var modelActions: LoginModelActions?
        weak var authManager: AuthenticationManager?
        
        init(modelActions: LoginModelActions? = nil) {
            self.modelActions = modelActions
        }
        
        func loginWithEmail(email: String, password: String) async {
            if let authManager {
                do {
                    try await authManager.cognitoEmailLogin(email: email, password: password)
                    return
                } catch {
                    print("Error")
                    return
                }
            }
            print("No manager for auth given on Login Intent")
            
        }
        
        func setAuthManager(_ manager: AuthenticationManager) {
            self.authManager = manager
        }
    }
}
