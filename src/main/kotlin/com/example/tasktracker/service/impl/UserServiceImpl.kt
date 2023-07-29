package com.example.tasktracker.service.impl

import com.example.tasktracker.model.User
import com.example.tasktracker.repository.UserRepository
import com.example.tasktracker.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    val userRepository: UserRepository
) : UserService {

    override fun save(user: User): User {
        return userRepository.save(user)
    }

    override fun findById(id: Long): User {
        return userRepository.findById(id).get()
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun deleteById(id: Long) {
        userRepository.deleteById(id)
    }
}