//
//  USer.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation
struct User: Identifiable {
    var id: String
    var firstName: String
    var lastName: String
    var kind: UserKind
    
    var fullName: String {
        "\(firstName) \(lastName)"
    }
}

enum UserKind {
    case regular
    case admin
}
