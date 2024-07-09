//
//  Match.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

struct Match: Identifiable {
    let id: String
    let sport: Sport
    let beginDate: Date
    let status: Int
    let isNext: Bool
    
    var matchStatus: MatchStatus {
        return MatchStatus.getStatus(value: self.status)
    }
    
    static let Mock = Match(id: UUID().uuidString,
                            sport: .init(id: UUID().uuidString,
                                         name: "Football",
                                         numberOfPlayers: 11),
                            beginDate: Date.createDate(year: 2024, month: 7, day: 20, hour: 10) ?? Date.now,
                            status: 2,
                            isNext: true)
}

enum MatchStatus {
    case ongoing
    case upcoming
    case finished
    case unknown
    
    static func getStatus(value: Int) -> Self {
        switch value {
        case 1: return .ongoing
        case 2: return .upcoming
        case 0: return .finished
        default: return .unknown
        }
    }
}
