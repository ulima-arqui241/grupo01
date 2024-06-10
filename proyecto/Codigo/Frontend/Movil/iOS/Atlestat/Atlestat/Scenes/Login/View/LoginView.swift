//
//  LoginView.swift
//  Atlestat
//
//  Created by Franco Marquez(Personal iCloud) on 27/05/24.
//

import SwiftUI

struct LoginView: View {
    
    @State private var email = ""
    @State private var pass = ""
    
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
                    FormTextInput(placeholder: "Contrasena", text: $pass, icon: .lock ,secure: true)
                    CapsuleButton(text: "Ingresar") {
                        //TODO: Login
                    }
                    .padding(.horizontal)
                }.padding(.horizontal, 20)
                    .expandVertically()
                
                VStack (spacing: 20){
                    Button {
                        //TODO: Change password
                    } label: {
                        Text("Cambiar contrasena")
                            .foregroundStyle(AppColors.foregroundColor)
                            .shadow(color: AppColors.terciaryColor
                                    ,radius: 1)
                    }
                    
                    ColorDivider()
                        .padding(.horizontal, 40)
                    
                    Button {
                        //TODO: Create account
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
    }
}

#Preview {
    LoginView()
}
