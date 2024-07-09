//
//  MainTabView.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct MainTabView: View {
    
    @StateObject private var styleManager = TabBarStyleController()
    @State private var selection: MainTabs = .home
    
    var body: some View {
        TabView {
            Group{
                HomeFeed()
                    .tabItem {
                        Image(systemName: MainTabs.home.iconName)
                        Text("Home")
                    }
                    .tag(MainTabs.home)
                    
                PersonalizeUserView()
                    .tabItem {
                        Image(systemName: MainTabs.personalizeProfile.iconName)
                        Text("Profile")
                    }
            }
            .toolbarBackground(styleManager.tabBarBgColor, for: .tabBar)
            .toolbarBackground(.visible, for: .tabBar)
        }
        .tint(styleManager.accentColor)
        .environmentObject(styleManager)
    }
}

final class TabBarStyleController: ObservableObject{
    @Published var accentColor: Color = AppColors.secondaryColor
    @Published var tabBarBgColor: Color = AppColors.terciaryColor
}

enum MainTabs {
    case home
    case personalizeProfile
    
    var iconName: String {
        switch self {
        case .home: "house.fill"
        case .personalizeProfile: "person.fill"
        }
    }
}


#Preview {
    MainTabView()
}
