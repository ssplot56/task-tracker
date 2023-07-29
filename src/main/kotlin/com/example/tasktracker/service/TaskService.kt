package com.example.tasktracker.service

import com.example.tasktracker.model.Task

interface TaskService {
    fun save(task: Task): Task

    fun findById(id: Long): Task

    fun findAll(): List<Task>

    fun deleteById(id: Long)
}