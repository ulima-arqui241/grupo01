//
//  CapsuleButton.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI
struct CapsuleButton: View {
    var withBackground = true
    var text: String
    var doWhenPressed: () -> ()
    
    var body: some View {
        
        Button {
            doWhenPressed()
        } label: {
            HStack{
                Text(text)
                    .font(.headline)
                    .bold()

                    .expandHorizontally()
            }
            .bold()
            .foregroundColor(withBackground ? .white : AppColors.primaryColor)
            .padding(.vertical, 12)
            .background {
                if withBackground{
                    AppColors.primaryColor
                        .clipShape(Capsule())
                    
                } else {
                    Capsule()
                        .stroke(AppColors.primaryColor)
                }
            }
            .shadow(radius: 2)
        }
    }
}

#Preview {
    CapsuleButton(text: "TEXT") {}
}
