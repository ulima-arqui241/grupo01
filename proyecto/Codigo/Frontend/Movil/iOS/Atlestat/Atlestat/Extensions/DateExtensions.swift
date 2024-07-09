//
//  DateExtensions.swift
//  Atlestat
//
//  Created by Franco on 8/07/24.
//

import Foundation

extension Date {
    static func createDate(year: Int, month: Int, day: Int, hour: Int, minute: Int = 0) -> Date? {
        var dateComponents = DateComponents()
        dateComponents.year = year
        dateComponents.month = month
        dateComponents.day = day
        dateComponents.hour = hour
        dateComponents.minute = minute
        
        let calendar = Calendar.current
        
        return calendar.date(from: dateComponents)
    }

}
