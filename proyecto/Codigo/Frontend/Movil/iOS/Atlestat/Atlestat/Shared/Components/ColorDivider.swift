//
//  ColorDivider.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI

struct ColorDivider: View {
    
    var color: Color = AppColors.backgroundColor
    var width: CGFloat = 3
    
    var body: some View {
        Rectangle()
            .fill(color)
            .frame(height: width)
    }
}

#Preview {
    ColorDivider()
}
