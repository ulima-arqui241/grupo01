//
//  Router.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

protocol BaseRoutes: Hashable {
    func viewDestination() -> AnyView
}

@MainActor
protocol Router: ObservableObject {
    var navigationPath: NavigationPath { get set }
    func navigate(to destination: any Hashable)
    func navigateBack()
    func navigateToRoot()
}

extension Router {
    
    func navigateBack() {
        self.navigationPath.removeLast()
    }
    
    func navigateToRoot() {
        self.navigationPath.removeLast(self.navigationPath.count)
    }
}

@MainActor
class BaseRouter: Router {
    
    @Published var navigationPath: NavigationPath = .init()
    
    func navigate(to destination: any Hashable) {
        navigationPath.append(destination)
    }
    
}
