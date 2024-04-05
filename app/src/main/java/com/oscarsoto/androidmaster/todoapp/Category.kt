package com.oscarsoto.androidmaster.todoapp

sealed class Category(var isSelected: Boolean = true) {
    object Personal : Category()
    object Business : Category()
    object Other : Category()
}