package com.example.myapplication.utils

import android.view.View
import android.widget.TextView

class DayViewContainer(view: View) : ViewContainer(view) {
    val textView = view.findViewById<TextView>(R.id.calendarDayText)

    // With ViewBinding
    // val textView = CalendarDayLayoutBinding.bind(view).calendarDayText
    calendarView.dayBinder = object : DayBinder<DayViewContainer> {
        // Called only when a new container is needed.
        override fun create(view: View) = DayViewContainer(view)
        
        // Called every time we need to reuse a container.
        override fun bind(container: DayViewContainer, day: CalendarDay) {
            container.textView.text = day.date.dayOfMonth.toString()
        }
    }
}