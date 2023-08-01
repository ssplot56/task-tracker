package com.example.tasktracker.service

import com.example.tasktracker.model.User

interface UserService {
    fun save(user: User): User

    fun update(id: Long, user: User): User

    fun findById(id: Long): User

    fun findAll(): List<User>

    fun deleteById(id: Long)
}