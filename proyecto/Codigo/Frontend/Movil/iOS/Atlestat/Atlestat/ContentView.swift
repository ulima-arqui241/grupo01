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
            if auth.authenticationState == .authenticated {
                MainTabView()
            } else {
                LoginView()
            }
        }
        .environmentObject(auth)
    }
}

final class AuthenticationManager: ObservableObject {
    @Published var authenticationState: AuthenticationState = .authenticated
    @Published var user: User? = .init(id: UUID().uuidString,
                                       firstName: "Franco",
                                       lastName: "Marquez",
                                       kind: .admin)
}

#Preview {
    ContentView()
}


enum AuthenticationState {
    case authenticated
    case nonAuthenticated
}
