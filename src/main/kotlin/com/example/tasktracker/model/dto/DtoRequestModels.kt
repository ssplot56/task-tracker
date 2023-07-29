package com.example.tasktracker.model.dto

data class UserRequestDto(
    val name: String,
    val password: String
)

data class TaskRequestDto(
    val content: String,
    val userId: Long
)
