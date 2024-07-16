package com.example.androidmaster.syntax

fun main() {
    getMonth(1)
    getMonthQuarter(4)
    val semester = getMonthSemester(3)
    println(semester)
    getResult("Result")
}

fun getResult(value: Any) {
    when (value) {
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if (value) println("Heya")
    }
}

// more simplify than under
fun getMonthSemester(month: Int) = when (month) {
        in 1..6 -> "First semester of the year"
        in 7..12 -> "Second semester of the year"
        !in 1..12 -> "It's not a valid month: $month"
        else -> ""
    }

// fun getMonthSemester(month: Int): String {
//    return when (month) {
//        in 1..6 -> "First semester of the year"
//        in 7..12 -> "Second semester of the year"
//        !in 1..12 -> "It's not a valid month: $month"
//        else -> ""
//    }
// }

fun getMonthQuarter(month: Int) {

    when (month) {
        1, 2, 3 -> println("First quarter of the year")
        4, 5, 6 -> println("Second quarter of the year")
        7, 8, 9 -> println("Third quarter of the year")
        10, 11, 12 -> println("Fourth quarter of the year")
        else -> println("It's not a valid month: $month")
    }
}

fun getMonth(month: Int) {
    var theMonth = ""

    when (month) {
        1 -> println("January")
        2 -> println("February")
        3 -> println("March")
        4 -> {
            println("April")
            println("April")
        }
        5 -> println("May")
        6 -> println("June")
        7 -> println("July")
        8 -> println("August")
        9 -> println("September")
        10 -> println("October")
        11 -> println("November")
        12 -> println("December")
        else -> println("It's not a valid month: $month")
    }

    // return theMonth
}