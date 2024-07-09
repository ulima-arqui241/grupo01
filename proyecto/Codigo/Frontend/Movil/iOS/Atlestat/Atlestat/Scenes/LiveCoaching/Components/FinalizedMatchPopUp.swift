//
//  FInalizedMatchPopUp.swift
//  Atlestat
//
//  Created by Franco on 9/07/24.
//

import SwiftUI

struct FinalizedMatchPopUp: View {
    var match: Match
    var doWhenNextPressed: () -> ()
    var doOnExtraTime: () -> ()
    var doWhenCanceledPressed: () -> ()
    
   @State private var nextStep = false
    
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
                
                if nextStep {
                    VStack (spacing: 40) {
                        Text("¿Desea finalizar el partido?")
                            .font(.title2)
                            .fontWeight(.heavy)
                        
                        HStack {
                            Spacer()
                            CapsuleButton(withBackground: false, text: "Cancelar") {
                                doWhenCanceledPressed()
                            }
                            .frame(width: 125)
                            Spacer()
                            CapsuleButton(text: "Siguiente") {
                                doWhenNextPressed()
                            }
                            .frame(width: 125)
                            Spacer()
                        }
                        
                        
                    }
                    .frame(height: 200)
                } else {
                    VStack {
                        Text("Finalizado")
                            .font(.title)
                            .fontWeight(.heavy)
                        
                        CapsuleButton(text: "Siguiente") {
                            nextStep = true
                        }
                        .frame(width: 160)
                        
                        Button(action: {
                            doOnExtraTime()
                        }, label: {
                            Text("Agregar tiempo extra")
                                .padding(.vertical)
                                .bold()
                                .foregroundStyle(AppColors.primaryColor)
                        })
                    }
                    .frame(height: 200)
                    
                }
                
                
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
        FinalizedMatchPopUp(match: .Mock, doWhenNextPressed: {}, doOnExtraTime: {}, doWhenCanceledPressed: {}).padding(.horizontal)
    }
}
