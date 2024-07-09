//
//  MVIContainer.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//
import Combine
import Foundation

final class MVIContainer<Intent, Model>: ObservableObject {
    
    let intent: Intent
    let model: Model
    
    private var cancellable: Set<AnyCancellable> = []
    
    /* Unfortunately, you can’t specify the type ObjectWillChangePublisher
     through generics, so we’ll specify it with an additional property */
    init(intent: Intent, model: Model, modelChangePublisher: ObjectWillChangePublisher) {
        self.intent = intent
        self.model = model
        
        /* It's necessary to ensure that changes in the Model will
         receive View, and not just Container */
        modelChangePublisher
            .receive(on: RunLoop.main)
            .sink(receiveValue: objectWillChange.send)
            .store(in: &cancellable)
    }
}
