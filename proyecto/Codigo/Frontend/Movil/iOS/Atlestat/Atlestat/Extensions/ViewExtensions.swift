//
//  ViewExtensions.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI

extension View {
    func formBorder() -> some View {
        self
            .padding(.vertical, 12)
            .padding(.horizontal, 15)
            .overlay {
                RoundedRectangle(cornerRadius: 10)
                    .stroke(AppColors.foregroundColor)
            }
    }
    
    func expand(_ alignment: Alignment = .center) -> some View {
        self
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: alignment)
    }
    
    func expandVertically(_ alignment: Alignment = .center) -> some View {
        self
            .frame(maxHeight: .infinity, alignment: alignment)
    }
    
    func expandHorizontally(_ alignment: Alignment = .center) -> some View {
        self
            .frame(maxWidth: .infinity, alignment: alignment)
    }
    
}
