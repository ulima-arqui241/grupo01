//
//  Request.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import Foundation

struct RegisterRequest: Encodable {
    var names: String
    var lastNames: String
    var birthDate: Date
    var gender: String
    var phoneNumber: String
    var address: String
}
