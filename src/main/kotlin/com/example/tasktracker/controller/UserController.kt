package com.example.tasktracker.controller

import com.example.tasktracker.model.User
import com.example.tasktracker.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : User {
        return userService.findById(id)
    }

    @GetMapping
    fun findAll() : List<User> {
        return userService.findAll()
    }
}