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


#Preview {
    ContentView()
}


