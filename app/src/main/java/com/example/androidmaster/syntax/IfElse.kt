package com.example.androidmaster.syntax

fun main() {
    basicIf()
    nestedIf()
    booleanIf()
    intIf()
    multipleIfAND()
    multipleIfOR()
}

fun multipleIfOR() {
    val pet: String = "dog"
    val isHappy: Boolean = true

    if (pet == "dog" || (pet == "cat" && isHappy)) {
        println("It's dog or cat")
    } else {
        println("It's not a dog or cat")
    }
}

fun multipleIfAND() {
    var age: Int = 18
    var parentPermission: Boolean = true
    var amIHappy: Boolean = true

    if (age >= 18 && parentPermission && amIHappy) {
        println("Drink beer")
    } else {
        println("Drink water")
    }
}

fun intIf() {
    val age: Int = 17

    if (age >= 18) {
        println("Drink beer")
    } else {
        println("Drink water")
    }
}

fun booleanIf() {
    val amIHappy: Boolean = true

    if (!amIHappy) {
        println("I am sad")
    } else {
        println("I am happy")
    }
}

fun nestedIf() {
    val animal: String = "dog"

    if (animal == "dog") {
        println("It's a dog")
    } else if (animal == "cat") {
        println("It's a cat")
    } else if (animal == "bird") {
        println("It's a bird")
    }
    else {
        println("It's not one of the expected animals")
    }
}

fun basicIf() {
    val name: String = "Cual"

    if (name == "Fulano") {
        println("Hey, the name variable is Fulano")
    } else {
        println("Hey, the name variable is not Fulano")
    }
}