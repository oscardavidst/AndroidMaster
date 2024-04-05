package com.oscarsoto.androidmaster.exercises

fun main() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println(
        "El precio de la entrada a cine para una persona de $child años es de \$${
            ticketPrice(
                child,
                isMonday
            )
        }"
    )
    println(
        "El precio de la entrada a cine para una persona de $adult años es de \$${
            ticketPrice(
                adult,
                isMonday
            )
        }"
    )
    println(
        "El precio de la entrada a cine para una persona de $senior años es de \$${
            ticketPrice(
                senior,
                isMonday
            )
        }"
    )
}

fun ticketPrice(age: Int, isMonday: Boolean): Int =
    when (age) {
        in 0..12 -> 15
        in 13..60 -> if (isMonday) 25 else 30
        in 60..100 -> 20
        else -> -1
    }