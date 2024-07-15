//
//  RegisterViewSecond.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

struct RegisterViewSecond: View {
    
    @EnvironmentObject var router: BaseRouter
    
    @State private var email = "franco1.alfra@gmail.com"
    @State private var password = "Contra1."
    @State private var passwordConfirmation = "Contra1."
    
    var registerStep1Info: RegisterStep1
    
    var body: some View {
        VStack {
            AppImages.titleIcon
            .resizable()
            .scaledToFit()
            .frame(width: 200)
            .frame(height: 200)
            
            VStack(spacing: 25) {
                FormTextInput(placeholder: "Email", text: $email, icon: .person)
                FormTextInput(placeholder: "Contrasena", text: $password, icon: .lock, secure: true)
                FormTextInput(placeholder: "Confirmar contrasena", text: $passwordConfirmation, icon: .lock, secure: true)
            }
            .padding(.horizontal)
            .expandVertically()
            
            CapsuleButton(text: "Continuar registro") {
                router.navigate(to: RegisterView.Routes.codeValidation(.init(step1Info: registerStep1Info,
                                                                             email: email,
                                                                             password: password)))
            }
            .padding(.horizontal, 50)
            .padding(.bottom, 30)
        }
        .modifier(AddBackButton(doWhenPressed: {
            router.navigateBack()
        }))
        .expandVertically()
        .navigationBarBackButtonHidden()
    }
}
