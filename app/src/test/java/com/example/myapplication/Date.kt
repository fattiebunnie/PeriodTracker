package com.example.myapplication

import java.text.SimpleDateFormat
import java.util.*


class Date {

//    private val startDateArrayList = arrayListOf<Pair>()

    val startDateList = mutableListOf<Int>()
    val

    var date : String =
        SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

//    startDatePair : Pair<Int, Long> =

//    val startDateArrayList : List<Int>

    fun getLongDate (date : String) : Long {
        return date.toLong()
    }

}