//
//  Player.swift
//  Atlestat
//
//  Created by Franco on 9/07/24.
//

import Foundation
class Player: Identifiable {
    let id: String
    let firstName: String
    let lastName: String
    let photoUrl = "https://picsum.photos/id/237/200/300"
    var stats: PlayerStats
    
    init(id: String, firstName: String, lastName: String, stats: PlayerStats) {
        self.id = id
        self.firstName = firstName
        self.lastName = lastName
        self.stats = stats
    }
    
    var fullName: String {
        "\(firstName) \(lastName)"
    }
    
    static var TeamPlayersInitialMock = [
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
        Player(id: UUID().uuidString, firstName: "Marco", lastName: "Landauro", stats: .Base),
    ]
}

struct PlayerStats {
    let calification: Float
    let goals: Int
    let assists: Int
    let completedPasses: Int
    let completedDribles: Int
    let wonDuelsNumber: Int
    let goalShoots: Int
    
    static var Base = PlayerStats(calification: 0,
                                  goals: 0,
                                  assists: 0,
                                  completedPasses: 0,
                                  completedDribles: 0,
                                  wonDuelsNumber: 0,
                                  goalShoots: 0)
}
