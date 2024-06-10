//
//  FormTextInput.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI

struct FormTextInput: View {
    
    var placeholder: String
    @Binding var text: String
    var icon: FormInputIcons?
    var secure = false
    @State private var showPassword = false
    
    var body: some View {
        HStack (spacing: 10) {
            if let icon{
                icon.getIcon()
            }
            
            if secure {
               SecureField(placeholder, text: $text)
            } else {
                TextField(placeholder, text: $text)
            }
            
        }
        .formBorder()
    }
}

//TODO: Replace secure text field with  the one with eye

struct SecureShowableTextField: View {
    @State private var showPassword = false
    var placeholder: String
    @Binding var text: String
    
    var body: some View {
        
        ZStack {
            SecureField(placeholder, text: $text)
        }
        
    }
}

#Preview {
    FormTextInput(placeholder: "Nombres", text: .constant(""), icon: .mail)
}

enum FormInputIcons: String {
    case mail = "envelope.fill"
    case calendar = "calendar"
    case lock = "lock"
    case person = "person.fill"
    case gender = "person.crop.circle.badge.questionmark"
    case home = "house.circle.fill"
    case eyeSlash = "eye.slash.fill"
    case eye = "eye.fill"
    
    func getIcon() -> some View {
        Image(systemName: self.rawValue)
            .resizable()
            .scaledToFit()
            .frame(width: 20, height: 20)
    }
}
