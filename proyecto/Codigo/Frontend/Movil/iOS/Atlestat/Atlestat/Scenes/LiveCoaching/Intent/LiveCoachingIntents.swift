//
//  LiveCoachingIntents.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

protocol LiveCoachingIntentProtocol {
    func showStartPopUp()
    func showFinalizedPopUp()
    func startMatch()
    func hidePopUp()
    func showPopUpToChangeStats(player: Player)
    func saveNewPlayerStats(stats: PlayerStats, id: String)
}

extension LiveCoachingScene {
    final class Intent: LiveCoachingIntentProtocol {
        private weak var modelActions: LiveCoachingModelActions?
        
        init(modelActions: LiveCoachingModelActions?) {
            self.modelActions = modelActions
        }
        
        func showStartPopUp() {
            modelActions?.changePopUpState(newStatus: .showStart)
        }
        
        func showFinalizedPopUp() {
            modelActions?.changePopUpState(newStatus: .showFinalized)
        }
        
        func startMatch() {
            modelActions?.changeMatchStatus(newStatus: .ongoing)
            hidePopUp()
        }
        
        func hidePopUp() {
            modelActions?.changePopUpState(newStatus: .hidden)
        }
        
        func showPopUpToChangeStats(player: Player) {
            modelActions?.changePopUpState(newStatus: .showEditPlayerStats(player: player))
        }
        
        func saveNewPlayerStats(stats: PlayerStats, id: String) {
            modelActions?.updatePlayerStats(newStats: stats, playerId: id)
            hidePopUp()
        }
    }
}
