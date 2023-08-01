package com.example.tasktracker.model.dto

import java.time.LocalDateTime

data class UserResponseDto(
    val id: Long,
    val name: String
)

data class TaskResponseDto(
    val id: Long,
    val content: String,
    val updateDate: LocalDateTime,
    val isFinished: Boolean,
    val userId: Long
)
