package com.oscarsoto.androidmaster.sintaxis

fun main() {
    val age: Short = 28
    val cash: Long? = null
    val salary: Float = 6910000f
    val char: Char = 'o'
    val name: String = "Oscar David Soto Tellez canon"
    val isFinish: Boolean = true

    var num = cash ?: 2
    println("num = ${num}")
}

fun sumar(numberOne: Int, numberTwo: Int): Int {
    return numberOne + numberTwo
}