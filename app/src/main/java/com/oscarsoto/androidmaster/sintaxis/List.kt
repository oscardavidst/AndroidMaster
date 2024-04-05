package com.oscarsoto.androidmaster.sintaxis

fun main() {
    inmutableList()
    mutableList()

}

fun mutableList() {
    val weekDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    weekDays.add("Oscar")
    weekDays.add(2,"Oscar")
    var noEsVacia = weekDays.isNotEmpty()
}

fun inmutableList() {
    val weekDays:List<String> = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    println(weekDays.last())

    for (weekDay in weekDays) {
        println(weekDay)
    }

    val day = weekDays.filter { it.equals("Martes") }
    println(day)
}
