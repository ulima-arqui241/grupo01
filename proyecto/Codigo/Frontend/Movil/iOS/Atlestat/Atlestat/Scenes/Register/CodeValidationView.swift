//
//  CodeValidationView.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

struct CodeValidationView: View {
    
    @EnvironmentObject var router: BaseRouter
    @EnvironmentObject var auth: AuthenticationManager
    
    @State private var verificationCode = ""
    @State private var isVerified = false
    
    var registerInfo: RegisterFinalInfo
    
    var body: some View {
        VStack {
            AppImages.titleIcon
                .resizable()
                .scaledToFit()
                .frame(width: 200)
                .frame(height: 200)
            
            VStack {
                
                VStack (spacing: 25){
                    Text("Se ha enviado un correo a su direccion de correo. Por favor ingrese el codigo de verificacion enviado para poder terminar su proceso de registro")
                    
                    FormTextInput(placeholder: "Codigo de verificacion", text: $verificationCode)
                        .padding(.horizontal, 5)
                        .padding(.top, 30)
                    
                    CapsuleButton(text: "Verificar") {
                        isVerified = true
                    }
                    .frame(width: 160)
                }
                .padding(.horizontal)
                .expandVertically(.top)
                
                CapsuleButton(text: "Iniciar sesion") {
                    auth.changeAuthState(state: .nonAuthenticated)
                }
                .padding(.horizontal, 50)
                .padding(.bottom, 30)
                .disabled(!isVerified)
                .opacity(isVerified ? 1 : 0.5)
                
            }
            
        }
        .expand()
        .modifier(AddBackButton(doWhenPressed: {
            router.navigateBack()
        }))
        .navigationBarBackButtonHidden()
    }
}
