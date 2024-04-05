package com.oscarsoto.androidmaster.sintaxis

fun main() {
    var weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");

    for (weekDay in weekDays) {
        println(weekDay)
    }

    for (position in weekDays.indices) {
        println(position)
    }

    for ((position, value) in weekDays.withIndex()) {
        println("$position: $value")
    }
}