//
//  LoginModel.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import Foundation

extension LoginView {
    final class Model: ObservableObject, LoginModelState {
        @Published var isLogged: Bool = false
    }
}

extension LoginView.Model: LoginModelActions {
    func setUserAsLoggged() {
        isLogged = true
    }
}
