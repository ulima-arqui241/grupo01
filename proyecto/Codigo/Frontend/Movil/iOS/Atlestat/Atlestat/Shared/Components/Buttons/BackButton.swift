//
//  BackButton.swift
//  Atlestat
//
//  Created by Franco on 14/07/24.
//

import SwiftUI

struct AddBackButton: ViewModifier {
    var doWhenPressed: () -> ()
    
    func body(content: Content) -> some View {
        content
            .overlay (alignment: .topLeading) {
                Button {
                    doWhenPressed()
                } label: {
                    HStack (spacing: 5){
                        Image(systemName: "chevron.left")
                            .resizable()
                            .scaledToFit()
                            .fontWeight(.medium)
                            .frame(width: 20, height: 20)
                        
                        Text("Regresar")
                    }
                    .foregroundStyle(AppColors.foregroundColor)
                }
                .padding(5)
                .padding(.top, 1)
            }
        
    }
}
