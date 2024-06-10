//
//  CapsuleButton.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI
struct CapsuleButton: View {
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
            .foregroundColor(.white)
            .padding(.vertical, 12)
            .background {
                AppColors.primaryColor
            }
            .clipShape(Capsule())
            .shadow(radius: 2)
        }
    }
}

#Preview {
    CapsuleButton(text: "TEXT") {}
}
