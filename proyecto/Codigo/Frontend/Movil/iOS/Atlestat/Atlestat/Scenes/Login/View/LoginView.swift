//
//  LoginView.swift
//  Atlestat
//
//  Created by Franco Marquez(Personal iCloud) on 27/05/24.
//

import SwiftUI

struct LoginView: View {
    
    @StateObject var container: MVIContainer<LoginIntentProtocol, LoginModelState>
    private var intent: LoginIntentProtocol { container.intent }
    private var modelState: LoginModelState { container.model }
    
    @State private var email = "mrcoalba@gmail.com"
    @State private var password = "Contra1."
    
    @EnvironmentObject var authManager: AuthenticationManager
     
    init() {
        let model = Model()
        let intent = Intent(modelActions: model)
        let container = MVIContainer(intent: intent as LoginIntentProtocol,
                                     model: model as LoginModelState,
                                     modelChangePublisher: model.objectWillChange)
        self._container = StateObject(wrappedValue: container)
    }
    
    var body: some View {
        ZStack{
            VStack {
                AppImages.icon
                    .resizable()
                    .scaledToFit()
                    .frame(width: 40)
                    .padding(10)
                    .background {
                        Circle()
                            .fill(.white)
                            .shadow(radius: 2)
                    }
                    .padding(.leading, 20)
                    .padding(.top,20)
            }
            .expand(.topLeading)
            
            
            VStack{
                
                AppImages.titleIcon
                    .resizable()
                    .scaledToFit()
                    .frame(width: 200)
                    .expandVertically()
                
                VStack (spacing: 25) {
                    FormTextInput(placeholder: "Mail", text: $email, icon: .mail)
                    FormTextInput(placeholder: "Contraseña", text: $password, icon: .lock ,secure: true)
                    CapsuleButton(text: "Ingresar") {
                        //TODO: Login
                        Task {
                            await intent.loginWithEmail(email: email, password: password)
                        }
                    }
                    .padding(.horizontal)
                }.padding(.horizontal, 20)
                    .expandVertically()
                
                VStack (spacing: 20){
                    Button {
                        //TODO: Change password
                    } label: {
                        Text("Cambiar contraseña")
                            .foregroundStyle(AppColors.foregroundColor)
                            .shadow(color: AppColors.terciaryColor
                                    ,radius: 1)
                    }
                    
                    ColorDivider()
                        .padding(.horizontal, 40)
                    
                    Button {
                        authManager.changeAuthState(state: .register)
                    } label: {
                        Text("Crear cuenta")
                            .foregroundStyle(AppColors.foregroundColor)
                            .shadow(color: AppColors.terciaryColor
                                    ,radius: 1)
                    }
                }
                .padding(.vertical)
            }
            
        }
        .onAppear {
            self.intent.setAuthManager(authManager)
        }
    }
}

#Preview {
    LoginView()
}
