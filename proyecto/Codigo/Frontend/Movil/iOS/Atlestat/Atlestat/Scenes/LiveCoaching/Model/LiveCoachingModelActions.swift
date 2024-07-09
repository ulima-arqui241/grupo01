//
//  LiveCoachingModelActions.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

protocol LiveCoachingModelActions: AnyObject {
    func changePopUpState(newStatus: LiveCoachingPopUpsState)
    func changeMatchStatus(newStatus: MatchStatus)
    func updatePlayerStats(newStats: PlayerStats, playerId: String)
}
