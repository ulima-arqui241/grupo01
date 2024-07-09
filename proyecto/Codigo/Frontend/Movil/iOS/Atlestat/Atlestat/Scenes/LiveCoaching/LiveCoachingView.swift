//
//  LiveCoachingView.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct LiveCoachingScene {
    struct MainView: View {
        @EnvironmentObject var router: BaseRouter
        
        @StateObject var container: MVIContainer<LiveCoachingIntentProtocol,LiveCoachingModelState>
        
        private var intent: LiveCoachingIntentProtocol { container.intent }
        private var modelState: LiveCoachingModelState { container.model }
        
        init() {
            let model = Model()
            let intent = Intent(modelActions: model)
            let container = MVIContainer(intent: intent as LiveCoachingIntentProtocol,
                                         model: model as LiveCoachingModelState, modelChangePublisher: model.objectWillChange)
            self._container = StateObject(wrappedValue: container)
        }
        
        var body: some View {
            AppHeader {
                //
            }
            ScrollView {
                VStack (spacing: 20) {
                    if modelState.matchStatus == .ongoing{
                        HStack {
                            Text("Tiempo de partido")
                                .font(.headline)
                                .bold()
                            
                            Spacer()
                            
                            Text("31:00")
                                .font(.title3)
                                .fontWeight(.black)
                        }
                        .padding()
                        .background {
                            AppColors.secondaryColor
                        }
                        .roundedBorder(radius: 20)
                    }
                    
                    Text("Equipo A")
                        .fontWeight(.black)
                        .expandHorizontally(.leading)
                    
                    Image("Field")
                        .fit()
                    
                    VStack (spacing: 25) {
                        Text("Lista de jugadores")
                            .fontWeight(.black)
                            .expandHorizontally(.leading)
                        
                        VStack (spacing: 40){
                            ForEach(modelState.players) { player in
                                PlayerCoachingCell(matchState: modelState.matchStatus, player: player) {
                                    //Do smth
                                } doWhenStatsPressed: {
                                    intent.showPopUpToChangeStats(player: player)
                                }
                            }
                        }
                        .padding(.bottom, 60)
                        
                    }
                }
                .padding()
            }
            .navigationBarBackButtonHidden()
            .overlay (alignment: .bottomTrailing) {
                Button(action: {
                    switch modelState.matchStatus {
                    case .upcoming:
                        intent.showStartPopUp()
                    case .ongoing:
                        intent.showFinalizedPopUp()
                    default: break
                    }
                }, label: {
                    Image(systemName: "chevron.right")
                        .fit()
                        .foregroundStyle(Color.white)
                        .frame(width: 37, height: 37)
                        .padding(15)
                        .background {
                            AppColors.primaryColor
                                
                        }
                        .roundedBorder(radius: 10)
                        .shadow(radius: 20)
                })
                .padding(.trailing, 35)
                .padding(.bottom)
            }
            .overlay {
                if modelState.popUpState != .hidden {
                    ZStack {
                        Color.black.opacity(0.8)
                            .allowsHitTesting(true)
                        
                        Group {
                            switch modelState.popUpState {
                            case .hidden:
                                EmptyView()

                            case .showStart:
                                StartMatchPopUp(match: modelState.match) {
                                    intent.startMatch()
                                }

                            case .showFinalized:
                                FinalizedMatchPopUp(match: modelState.match) {
                                    router.navigateToRoot()
                                } doOnExtraTime: {
                                    //
                                } doWhenCanceledPressed: {
                                    intent.hidePopUp()
                                }
                            case let .showEditPlayerStats(person):
                                PlayerStatsModPopUp(player: person) { newStats, playerId in
                                    intent.saveNewPlayerStats(stats: newStats, id: playerId)
                                }
                            }
                        }
                        .padding(.horizontal)
                        
                    }
                } else {
                    EmptyView()
                }
            }
        }
    }
}



#Preview {
    LiveCoachingScene.MainView()
}
