package com.example.androidmaster.todoapp

// sealed is similar to closed
sealed class TaskCategory {

    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}