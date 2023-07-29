package com.example.tasktracker.controller

import com.example.tasktracker.model.User
import com.example.tasktracker.model.dto.UserRequestDto
import com.example.tasktracker.model.dto.UserResponseDto
import com.example.tasktracker.service.UserService
import com.example.tasktracker.service.mapper.impl.UserMapper
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(
    val userService: UserService,
    val userMapper: UserMapper
) {
    @PostMapping
    fun save(@RequestBody requestDto: UserRequestDto) : UserResponseDto {
        return userMapper.mapToDto(userService.save(userMapper.mapToModel(requestDto)))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : User {
        return userService.findById(id)
    }

    @GetMapping
    fun findAll() : List<UserResponseDto> {
        return userService.findAll()
            .map { user -> userMapper.mapToDto(user) }
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        userService.deleteById(id)
    }
}