package com.example.androidmaster.syntax

fun main() {

    immutableList()
    mutableList()
}

fun immutableList() {

    println("------------ Immutable List")
    val weekDays: List<String> = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    println(weekDays.size)
    println(weekDays.get(3))
    println(weekDays[3])
    println(weekDays.first())
    println(weekDays.last())
    println(weekDays)

    // it = iterator and must be it not ti or ab, etc
    val filter1 = weekDays.filter { it.contains("e") }
    println(filter1)
    val filter2 = weekDays.filter { it == "Monday" || it == "Thursday" }
    println(filter2)

    weekDays.forEach { println(it) }
    // Other way
    weekDays.forEach { weekDay -> println(weekDay) }
}

fun mutableList() {

    println("------------ Mutable List")
    var weekDays: MutableList<String> = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    println(weekDays)
    weekDays.add("Sleepsunday")

    println(weekDays.size)
    println(weekDays)

    weekDays.add(0, "Lunes")
    println(weekDays[0])
    println(weekDays.size)

    weekDays.add(0, "Monday")
    println(weekDays[0])
    println(weekDays.size)

    weekDays.removeAt(0)
    weekDays.removeAt(0)
    weekDays.removeAt(7)
    println("------- $weekDays")

    println(weekDays.none())
    println(weekDays.firstOrNull())
    println(weekDays.elementAtOrNull(6))
    println(weekDays.lastOrNull())
    println(weekDays.isEmpty())
    println(weekDays.isNotEmpty())

    for (position in weekDays.indices) {
        println(weekDays.get(position))
    }

    for ((index, item) in weekDays.withIndex()) {
        println("$index $item")
    }

    for (item in weekDays) {
        println(item)
    }

    weekDays.forEach { println(it) }

    weekDays.forEach { weekDay -> println(weekDay) }
}