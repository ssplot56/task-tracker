package com.example.tasktracker.model.dto

data class UserResponseDto(
    val id: Long,
    val name: String
)

data class TaskResponseDto(
    val id: Long,
    val content: String,
    val userId: Long
)
