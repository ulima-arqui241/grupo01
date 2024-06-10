//
//  Style.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI

typealias AppColors = AppStyle.Colors
typealias AppImages = AppStyle.Images

struct AppStyle {
    struct Colors {
        static let foregroundColor = Color(red: 55/255, green: 71/255, blue: 79/255)
        //TODO: Decide correct names for colors
        static let backgroundColor = Color(red: 207/255, green: 216/255, blue: 220/225)
        static let lighterBackgroundColor = Color(red: 236/255, green: 239/255, blue: 241/255)
        static let primaryColor = Color(red: 0, green: 96/255, blue: 100/255)
        static let secondaryColor = Color(red: 128/255, green: 222/255, blue: 234/255)
        static let terciaryColor = Color(red: 224/255, green: 247/255, blue: 250/255)
    }
    
    struct Images {
        static let icon = Image("Icon")
        static let titleIcon = Image("Title")
    }
}
