//
//  LiveCoachingModelState.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

protocol LiveCoachingModelState {
    var match: Match { get }
    var players: [Player] { get }
    var matchStatus: MatchStatus { get }
    var numberOfPeriods: Int { get }
    var popUpState: LiveCoachingPopUpsState { get }
}

enum LiveCoachingPopUpsState: Equatable {
    static func == (lhs: LiveCoachingPopUpsState, rhs: LiveCoachingPopUpsState) -> Bool {
        switch lhs {
        case .hidden:
            switch rhs {
            case .hidden: return true
            default: return false
            }
        case .showStart:
            switch rhs {
            case .showStart: return true
            default: return false
            }
        case .showFinalized:
            switch rhs {
            case .showFinalized: return true
            default: return false
            }
        case .showEditPlayerStats(let player):
            switch rhs {
            case let .showEditPlayerStats(player2): return player.id == player2.id
            default: return false
            }
        }
    }
    
    case hidden
    case showStart
    case showFinalized
    case showEditPlayerStats(player: Player)
}
