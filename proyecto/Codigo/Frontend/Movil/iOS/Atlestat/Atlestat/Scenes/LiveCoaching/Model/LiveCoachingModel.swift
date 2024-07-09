//
//  LiveCoachingModel.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

extension LiveCoachingScene {
    final class Model: ObservableObject, LiveCoachingModelState {
        @Published var match: Match = .Mock
        @Published var matchStatus: MatchStatus = .upcoming
        @Published var numberOfPeriods = 2
        @Published var players: [Player] = Player.TeamPlayersInitialMock
        @Published var popUpState: LiveCoachingPopUpsState = .hidden
    }
}


extension LiveCoachingScene.Model: LiveCoachingModelActions {
    func changePopUpState(newStatus: LiveCoachingPopUpsState) {
        self.popUpState = newStatus
    }
    
    func changeMatchStatus(newStatus: MatchStatus) {
        self.matchStatus = newStatus
    }
    
    func updatePlayerStats(newStats: PlayerStats, playerId: String){
        if let index = players.firstIndex(where: {
            $0.id == playerId
        }){
            players[index].stats = newStats
        }
    }
}

