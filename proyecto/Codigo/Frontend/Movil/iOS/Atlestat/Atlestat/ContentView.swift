//
//  ContentView.swift
//  Atlestat
//
//  Created by Franco Marquez(Personal iCloud) on 27/05/24.
//

import SwiftUI

struct ContentView: View {
    
    @StateObject private var auth = AuthenticationManager()
    
    var body: some View {
        Group {
            switch auth.authenticationState {
            case .authenticated:
                MainTabView()
            case .register:
                RegisterView()
            case .nonAuthenticated:
                LoginView()
            }
        }
        .environmentObject(auth)
    }
}


#Preview {
    ContentView()
}


