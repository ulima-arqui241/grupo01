//
//  FormButtonInput.swift
//  Atlestat
//
//  Created by Franco on 9/06/24.
//

import SwiftUI

struct FormButtonInput<T: Hashable & CaseIterable & RawRepresentable>: View where T.AllCases: RandomAccessCollection, T.RawValue == String {
    
    var icon: FormInputIcons?
    var placeholderText: String
    @Binding var selection: T
    
    var body: some View {
        Picker(selection: $selection) {
            ForEach(T.allCases, id: \.self) {
                Text("\($0.rawValue)")
            }
        } label: {
            HStack {
                
                if let icon {icon.getIcon()}
                
                Text(placeholderText)
                    .foregroundStyle(.gray)
                    .expandHorizontally(.leading)
                
                Image(systemName: "chevron.right")
                    .resizable()
                    .scaledToFit()
                    .frame(width: 10)
                
            }
            .formBorder()
        }
        .pickerStyle(.navigationLink)
    }
}

#Preview {
    NavigationStack{
        FormButtonInput<Genders>(icon: .gender, placeholderText: "Genero", selection: .constant(Genders.Male))
    }
}

enum Genders: String, CaseIterable {
    case Male
    case Female
    case Other
}
