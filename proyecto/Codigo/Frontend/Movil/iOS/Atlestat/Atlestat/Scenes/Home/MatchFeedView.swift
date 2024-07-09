//
//  MatchFeedView.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct MatchFeedView: View {
    
    var match: Match
    var doOnEditPressed: () -> ()
    
    var body: some View {
        VStack {
            if match.isNext {
                Text("Próximo partido")
                    .fontWeight(.heavy)
                    .expandHorizontally(.leading)
            }
            
            VStack {
                AppImages.matchImage
                    .fill()
                    .frame(height: 116)
                    .clipped()
                
                VStack {
                    //TODO: Usar date
                    Text("Partido de practica")
                        .font(.headline)
                        .expandHorizontally(.leading)
                        .bold()
                    Text("Equipo A vs Equipo B")
                        .font(.title3)
                        .fontWeight(.heavy)
                        .expandHorizontally(.leading)
                        .padding(.bottom)
                    
                    HStack {
                        Text("20 de enero")
                        Text("90 minutos")
                            .expandHorizontally()
                        Text("11 jugadores")
                    }
                    .font(.headline)
                    
                    HStack {
                        Text("10:00 AM")
                            .font(.title3)
                            .fontWeight(.heavy)
                        Spacer()
                        CapsuleButton(text: "Editar") {
                            doOnEditPressed()
                        }
                        .frame(width: 115)
                    }
                    .padding(.vertical, 10)
                }
                .padding(.horizontal)
                
            }
            .background {
                Color.gray.opacity(0.2)
            }
            .roundedBorder(radius: 10)
            
        }
    }
}

#Preview {
    MatchFeedView(match: .Mock){}
}
