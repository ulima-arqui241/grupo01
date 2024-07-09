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
    
    func roundedBorder(radius: CGFloat) -> some View {
        self
            .clipShape(RoundedRectangle(cornerRadius: radius))
    }
    
    func cornerRadius(_ radius: CGFloat, corners: UIRectCorner) -> some View {
        clipShape(RoundedCorner(radius: radius, corners: corners))
    }
    
}


struct RoundedCorner: Shape {
    let radius: CGFloat
    let corners: UIRectCorner
    
    init(radius: CGFloat = .infinity, corners: UIRectCorner = .allCorners) {
        self.radius = radius
        self.corners = corners
    }
    
    func path(in rect: CGRect) -> Path {
        let path = UIBezierPath(roundedRect: rect, byRoundingCorners: corners, cornerRadii: CGSize(width: radius, height: radius))
        return Path(path.cgPath)
    }
}
