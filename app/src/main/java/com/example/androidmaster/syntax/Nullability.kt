package com.example.androidmaster.syntax

fun main() {

    var name: String? = null

    // I'm sure is not null
    // println(name!![3])
    // println(name!!.get(3))

    println(name?.get(3) ?: "Is null")
}