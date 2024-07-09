//
//  HomeFeed.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct HomeFeed: View {
    
    @StateObject var router = BaseRouter()
    
    var body: some View {
        NavigationStack (path: $router.navigationPath) {
            AppHeader()
            ScrollView{
                VStack {
                    MatchFeedView(match: .Mock) {
                        router.navigate(to: Self.Routes.liveCoaching)
                    }
                }
                .padding()
            }
            .modifier(Self.NavigationModifier(router: router))
        }
    }
}

extension HomeFeed {
    enum Routes: BaseRoutes {
        
        case liveCoaching
        
        func viewDestination() -> AnyView {
            switch self {
            case .liveCoaching : AnyView(LiveCoachingScene.MainView())
            }
        }
    }
    
    struct NavigationModifier: ViewModifier {
        var router: BaseRouter
        func body(content: Content) -> some View {
            content
                .navigationDestination(for: Routes.self) { route in
                    route.viewDestination()
                        .environmentObject(router)
                }
        }
    }
}

#Preview {
    HomeFeed()
}
