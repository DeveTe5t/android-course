package com.example.androidmaster.syntax

/**
 * Varaibles
 */

fun main() {

    numericVariables()

    alphanumericVariables()

    booleanVariables()

    showMyName()
    showMyAge(50)
    showMyAge(currentAge = 12)
    showMyAge2()
    add(3, 4)
    val theSubtract: Int = subtract(firstNumber =  10, secondNumber =  7)
    println(theSubtract)
    val theSubtractCool: Int = subtractCool(20, 10)
    println(theSubtractCool)
}

/**
 * Functions
 */

// simple
fun numericVariables() {
    /**
     * Numeric variables
     */

    // Int
    // val similar to const
    val age: Int = 50
    // var similar to variable
    var age2: Int = 40

    // Long
    val variableLong: Long = 1230000000

    // Float
    val variableFloat: Float = 12.459834f

    // Double
    val variableDouble: Double = 2273856.034654643

    println("Addition: ")
    println(age + age2)
    println("Addition of $age + $age2 with interpolation: ${age + age2}")

    println("Substract")
    println(age - age2)

    println("Multiply")
    println(age * age2)

    println("Divide")
    println(age / age2)

    println("Module")
    println(age % age2)

    var exampleAdd: Int = age + variableFloat.toInt();
    println(exampleAdd)

    var exampleAdd2: Float = age + variableFloat;
    println(exampleAdd2)
}

fun alphanumericVariables() {
    /**
     * Alphanumeric variables
     */

    // Char
    val variable1Char: Char = 'a'
    val variable2Char: Char = '1'
    val variable3Char: Char = '$'

    // String
    val variableString: String = "Fulano de tal"
}

fun booleanVariables() {
    /**
     * Boolean variables
     */

    val variableBoolean: Boolean = true
}

fun showMyName() {
    println("My name is Fulano")
}

// with params
fun showMyAge(currentAge: Int) {
    println("I am $currentAge years old")
}

fun add(firstNumber: Int, secondNumber: Int) {
    println(firstNumber + secondNumber)
}

// with params and default value
fun showMyAge2(currentAge: Int = 20) {
    println("I am $currentAge years old")
}

// with params and return value
fun subtract(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}

fun subtractCool(firstNumber: Int, secondNumber: Int): Int = firstNumber - secondNumber