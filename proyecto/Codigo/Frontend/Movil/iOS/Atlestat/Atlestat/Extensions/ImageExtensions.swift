//
//  ImageExtensions.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

extension Image {
    func fit() -> some View{
        self
            .resizable()
            .scaledToFit()
    }
    
    func fill() -> some View {
        self
            .resizable()
            .scaledToFill()
    }
    
    func circleClipped(radius: CGFloat) -> some View {
        self
            .fill()
            .frame(height: radius * 2)
            .clipShape(Circle())
    }
}
