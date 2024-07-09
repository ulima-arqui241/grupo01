//
//  PlayerStatsModPopUp.swift
//  Atlestat
//
//  Created by Franco on 9/07/24.
//

import SwiftUI

struct PlayerStatsModPopUp: View {
    
    var player: Player
    var doWithNewStats: (_ stats: PlayerStats, _ playerId: String) -> ()
    @State private var calification = "0.0"
    @State private var goals = "0"
    @State private var assists = "0"
    @State private var passes = "0"
    @State private var dribles = "0"
    @State private var duels = "0"
    @State private var targetShoots = "0"
    
    init(player: Player, doWithNewStats: @escaping (_: PlayerStats, _: String) -> Void) {
        self.player = player
        self.doWithNewStats = doWithNewStats
        self._calification = State(initialValue: String(player.stats.calification))
        self._goals = State(initialValue: String(player.stats.goals))
        self._assists = State(initialValue: String(player.stats.assists))
        self._passes = State(initialValue: String(player.stats.completedPasses))
        self._dribles = State(initialValue: String(player.stats.completedDribles))
        self._duels = State(initialValue: String(player.stats.wonDuelsNumber))
        self._targetShoots = State(initialValue: String(player.stats.goalShoots))
    }
    
    var body: some View {
        VStack {
            Text(player.fullName)
                .font(.title3)
                .fontWeight(.heavy)
                .foregroundStyle(Color.white)
                .expandHorizontally()
                .frame(height: 75)
                .background {
                    AppColors.foregroundColor
                }
            
            StatEditCell(value: $calification, statName: "Calificacion", previousValue: "\(player.stats.calification)", isImportant: true)
            StatEditCell(value: $goals, statName: "Goles", previousValue: "\(player.stats.calification)")
            StatEditCell(value: $assists, statName: "Asistencias", previousValue: "\(player.stats.assists)")
            StatEditCell(value: $passes, statName: "Pases completados", previousValue: "\(player.stats.completedPasses)")
            StatEditCell(value: $dribles, statName: "Regates completados", previousValue: "\(player.stats.completedDribles)")
            StatEditCell(value: $duels, statName: "Duelos ganados", previousValue: "\(player.stats.wonDuelsNumber)")
            StatEditCell(value: $targetShoots, statName: "Tiros al arco", previousValue: "\(player.stats.goalShoots)")
            
            HStack {
                
                CapsuleButton(text: "Guardar") {
                    
                    var newCalification: Float? = nil
                    var newGoals: Int? = nil
                    var newAssists: Int? = nil
                    var newPasses: Int? = nil
                    var newDribles: Int? = nil
                    var newDuels: Int? = nil
                    var newGoalShoots: Int? = nil
                    
                    if let cal = Float(calification) {
                        newCalification = cal == player.stats.calification ? player.stats.calification : cal
                    }
                    
                    if let goal = Int(goals) {
                        newGoals = goal == player.stats.goals ? player.stats.goals : goal
                    }
                    
                    if let assist = Int(assists) {
                        newAssists = assist == player.stats.assists ? player.stats.assists : assist
                    }
                    
                    if let pass = Int(passes) {
                        newPasses = pass == player.stats.completedPasses ? player.stats.completedPasses : pass
                    }
                    
                    if let drible = Int(dribles) {
                        newDribles = drible == player.stats.completedDribles ? player.stats.completedDribles : drible
                    }
                    
                    if let duel = Int(duels) {
                        newDuels = duel == player.stats.wonDuelsNumber ? player.stats.wonDuelsNumber : duel
                    }
                    
                    if let goalshoot = Int(targetShoots) {
                        newGoalShoots = goalshoot == player.stats.goalShoots ? player.stats.goalShoots : goalshoot
                    }
                    
                    let newStats = PlayerStats(calification: newCalification ?? player.stats.calification,
                                               goals: newGoals ?? player.stats.goals,
                                               assists: newAssists ?? player.stats.assists,
                                               completedPasses: newPasses ?? player.stats.completedPasses,
                                               completedDribles: newDribles ?? player.stats.completedDribles,
                                               wonDuelsNumber: newDuels ?? player.stats.wonDuelsNumber,
                                               goalShoots: newGoalShoots ?? player.stats.goalShoots)

                    self.doWithNewStats(newStats, player.id)
                }
                .padding([.horizontal, .bottom])
                .frame(width: 130)
            }
            .expandHorizontally(.trailing)
            
        }
        .background {
            Color.white
        }
        .roundedBorder(radius: 20)
    }
}

struct StatEditCell: View {
    
    @Binding var value: String
    var statName: String
    var previousValue: String
    var isImportant = false
    
    var body: some View {
        HStack {
            Text("\(isImportant ? "☆ " : "")\(statName)")
                .font(isImportant ? .title3 : .headline)
                .fontWeight(isImportant ? .black : .bold)
            Spacer()
            TextField(previousValue, text: $value)
                .padding(5)
                .multilineTextAlignment(.center)
                .overlay {
                    Capsule()
                        .stroke(AppColors.foregroundColor)
                }
                .frame(width: 50)
                .keyboardType(.numberPad)
            
        }
        .padding(.horizontal)
    }
}

#Preview {
    ZStack{
        Color.purple
        PlayerStatsModPopUp(player: .TeamPlayersInitialMock[0]) {one,two in
            print(one)
        }
            .padding(.horizontal)
    }
}
