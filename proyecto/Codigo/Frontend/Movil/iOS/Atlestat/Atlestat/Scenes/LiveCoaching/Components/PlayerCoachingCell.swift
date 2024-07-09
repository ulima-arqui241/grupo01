//
//  PlayerCoachingCell.swift
//  Atlestat
//
//  Created by Franco on 9/07/24.
//

import SwiftUI

struct PlayerCoachingCell: View {
    
    var matchState: MatchStatus
    var player: Player
    var doWhenEditPressed: () -> ()
    var doWhenStatsPressed: (() -> ())?
    
    var body: some View {
        HStack {
            AsyncImage(url: URL(string: player.photoUrl)) { image in
                image
                    .circleClipped(radius: 20)
                    .frame(width: 40)
            } placeholder: {
                Circle()
                    .fill(Color.gray)
                    .frame(height: 40)
            }
            
            VStack (alignment: .leading){
                Text(player.fullName).bold()
                Text("Posicion X")
                    .foregroundStyle(AppColors.foregroundColor)
            }
            .expandHorizontally(.leading)
            
            switch matchState {
            case .ongoing:
                HStack {
                    Button {
                        doWhenEditPressed()
                    } label: {
                        Image(systemName: "pencil")
                            .resizable()
                            .foregroundStyle(Color.white)
                            .frame(width: 16, height: 16)
                            .padding(10)
                            .background {
                                AppColors.primaryColor
                            }
                            .clipShape(Circle())
                    }
                    
                    Button {
                        if let doWhenStatsPressed {
                            doWhenStatsPressed()
                        }
                    } label: {
                        HStack {
                            AppImages.icon
                                .resizable()
                                .frame(width: 22, height: 24)
                            
                            Text("Stats").bold()
                                .foregroundStyle(Color.black)
                        }
                        .padding(8)
                        .background {
                            AppColors.secondaryColor
                        }
                        .roundedBorder(radius: 20)
                    }
                }
            case .upcoming:
                CapsuleButton(text: "Editar") {
                    doWhenEditPressed()
                }
                .frame(width: 125)
            case .finished:
                EmptyView()
            case .unknown:
                EmptyView()
            }
            
            

        }
    }
}

#Preview {
    VStack{
        PlayerCoachingCell(matchState: .ongoing, player: .TeamPlayersInitialMock[0]){}
        PlayerCoachingCell(matchState: .upcoming, player: .TeamPlayersInitialMock[0]){}
    }
}
