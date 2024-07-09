//
//  StartMatchPopUp.swift
//  Atlestat
//
//  Created by Franco on 9/07/24.
//

import SwiftUI

struct StartMatchPopUp: View {
    var match: Match
    var doWhenNextPressed: () -> ()
    
    var body: some View {
        
        VStack {
            
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
                        .font(.title2)
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
                    
                    .padding(.vertical, 10)
                }
                .padding(.horizontal)
                
                VStack {
                    
                    VStack{
                        Text("10:00 AM")
                            .font(.title)
                            .fontWeight(.heavy)
                        Text("Hora actual 9:58 AM")
                            .font(.subheadline)
                            .fontWeight(.bold)
                            .foregroundStyle(Color.gray)
                    }
                    .padding(.bottom, 25)
                    
                    CapsuleButton(text: "Siguiente") {
                        doWhenNextPressed()
                    }
                    .frame(width: 160)
                }
                .padding(.vertical)
                
            }
            
        }
        .background(content: {
            Color.white
        })
        .roundedBorder(radius: 20)
    }
}

#Preview {
    ZStack {
        Color.black
        StartMatchPopUp(match: .Mock){}
    }
    
}
