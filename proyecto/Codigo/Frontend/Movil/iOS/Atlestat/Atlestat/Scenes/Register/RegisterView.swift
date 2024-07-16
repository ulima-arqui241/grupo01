//
//  RegisterView.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

struct RegisterView: View {
    
    @EnvironmentObject var auth: AuthenticationManager
    
    @StateObject private var router = BaseRouter()
    
    @State private var givenNames = "Franco Leonardo"
    @State private var familyNames = "Marquez Velasquez"
    @State private var birthDate = "20/12/2001"
    @State private var gender = "Masculino"
    @State private var address = "Lima"
    @State private var phoneNumber = "+51999999992"
    
    var body: some View {
        
        NavigationStack(path: $router.navigationPath) {
            VStack {
                AppImages.titleIcon
                    .resizable()
                    .scaledToFit()
                    .frame(width: 200)
                    .frame(height: 200)
                
                VStack (spacing: 25) {
                    FormTextInput(placeholder: "Nombres", text: $givenNames, icon: .person)
                    FormTextInput(placeholder: "Apellidos", text: $familyNames, icon: .person)
                    FormTextInput(placeholder: "Fecha de nacimiento (DD/MM/YYYY)", text: $birthDate, icon: .calendar)
                    FormTextInput(placeholder: "Genero", text: $gender, icon: .gender)
                    FormTextInput(placeholder: "Direccion", text: $address, icon: .home)
                    FormTextInput(placeholder: "Telefono", text: $phoneNumber)
                }
                .padding(.horizontal)
                .expandVertically()
                
                CapsuleButton(text: "Continuar registro") {
                    router.navigate(to: Routes.secondStep(.init(givenNames: givenNames,
                                                                familyNames: familyNames,
                                                                birthDate: birthDate,
                                                                gender: gender,
                                                                address: address, 
                                                                phoneNumber: phoneNumber)))
                }
                .padding(.horizontal, 50)
                .padding(.bottom, 30)
                
            }
            .expand()
            .modifier(AddBackButton(doWhenPressed: {
                auth.changeAuthState(state: .nonAuthenticated)
            }))
            .modifier(NavigationModifier(router: router))
        }
        
        
    }
}


extension RegisterView {
    enum Routes: BaseRoutes {
        case secondStep(RegisterStep1)
        case codeValidation(RegisterFinalInfo)
        
        func viewDestination() -> AnyView {
            switch self {
            case .secondStep(let info):
                AnyView(RegisterViewSecond(registerStep1Info: info))
            case .codeValidation(let info): AnyView(CodeValidationView(registerInfo: info))
            }
        }
    }
    
    struct NavigationModifier: ViewModifier {
        var router: BaseRouter
        func body(content: Content) -> some View {
            content
                .navigationDestination(for: Routes.self) { route in
                    route.viewDestination()
                        .environmentObject(router)
                }
        }
    }
}

struct RegisterStep1: Hashable {
    let givenNames: String
    let familyNames: String
    let birthDate: String
    let gender: String
    let address: String
    let phoneNumber: String
}

struct RegisterFinalInfo: Hashable {
    let step1Info: RegisterStep1
    let email: String
    let password: String
}
