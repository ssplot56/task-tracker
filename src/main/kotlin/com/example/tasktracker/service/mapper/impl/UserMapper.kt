package com.example.tasktracker.service.mapper.impl

import com.example.tasktracker.model.User
import com.example.tasktracker.model.dto.UserRequestDto
import com.example.tasktracker.model.dto.UserResponseDto
import com.example.tasktracker.service.mapper.RequestDtoMapper
import com.example.tasktracker.service.mapper.ResponseDtoMapper
import org.springframework.stereotype.Service

@Service
class UserMapper : RequestDtoMapper<UserRequestDto, User>,
    ResponseDtoMapper<UserResponseDto, User> {
    override fun mapToModel(dto: UserRequestDto): User {
        return User(null, dto.name, dto.password)
    }

    override fun mapToDto(entity: User): UserResponseDto {
        return UserResponseDto(entity.id!!, entity.name)
    }
}