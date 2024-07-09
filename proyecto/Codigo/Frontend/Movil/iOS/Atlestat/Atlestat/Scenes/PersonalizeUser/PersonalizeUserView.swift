//
//  PersonalizeUserView.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import SwiftUI

struct PersonalizeUserView: View {
    
    @StateObject var container: MVIContainer<PersonalizeUserIntentProtocol, PersonalizeUserModelState>
    
    
    private var intent: PersonalizeUserIntentProtocol { container.intent }
    private var modelState: PersonalizeUserModelState { container.model }
    
    init() {
        let model = PersonalizeUserModel()
        let intent = PersonalizeUserIntents(modelActions: model)
        let container = MVIContainer(intent: intent as PersonalizeUserIntentProtocol,
                                     model: model as PersonalizeUserModelState,
                                     modelChangePublisher: model.objectWillChange)
        self._container = StateObject(wrappedValue: container)
    }
    
    var body: some View {
        VStack {
            FormInputButton(placeholder: "Ingrese los deportes que le interese", text: "") {
                //do smth
            }
        }
    }
}

#Preview {
    PersonalizeUserView()
}
