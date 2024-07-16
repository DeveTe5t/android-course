package com.example.androidmaster.syntax

fun main() {

    val weekDays: Array<String> = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    println(weekDays[1])
    println(weekDays[weekDays.size -1])
    println(weekDays.get(2))
    println(weekDays.get(weekDays.size-1))

    weekDays[0] = "Lunes"
    println(weekDays[0])
    weekDays.set(0, "Monday")

    for (position in weekDays.indices) {
        println(weekDays.get(position))
    }

    for ((position, value) in weekDays.withIndex()) {
        println("$position: $value")
    }

    for (weekDay in weekDays) {
        println(weekDay)
    }
}