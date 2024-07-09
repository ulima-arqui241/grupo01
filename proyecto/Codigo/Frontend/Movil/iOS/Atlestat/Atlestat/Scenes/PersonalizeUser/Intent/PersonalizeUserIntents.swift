//
//  PersonalizeUserIntents.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

protocol PersonalizeUserIntentProtocol {
    
}

final class PersonalizeUserIntents: PersonalizeUserIntentProtocol {
    private weak var modelActions: PersonalizeUserModelActions?
    
    init(modelActions: PersonalizeUserModelActions?) {
        self.modelActions = modelActions
    }
    
}
