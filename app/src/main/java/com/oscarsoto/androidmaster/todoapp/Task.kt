package com.oscarsoto.androidmaster.todoapp

data class Task(val name: String, val category: Category, var isSelected: Boolean = false) {

}