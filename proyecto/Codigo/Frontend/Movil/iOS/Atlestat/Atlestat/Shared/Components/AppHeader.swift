//
//  AppHeader.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct AppHeader: View {
    
    var doWhenSettingsPressed: (() -> ())?
    
    var body: some View {
        HStack {
            AppImages.icon
                .fit()
                .frame(width: 30)
            AppImages.titleIcon
                .fit()
                .frame(width: 120)
            
            Spacer()
            
            if let doWhenSettingsPressed {
                Button {
                    doWhenSettingsPressed()
                } label: {
                    Image(systemName: "gear")
                        .fit()
                        .frame(width: 30)
                        .padding(5)
                        .foregroundStyle(Color.white)
                        .background {
                            Color.gray
                                .opacity(0.8)
                        }
                        .clipShape(Circle())
                }
            }
        }
        .padding(.horizontal, 10)
        .expandHorizontally()
        .frame(height: AppStyle.Constants.headerHeight)
    }
}

#Preview {
    AppHeader(){}
}
