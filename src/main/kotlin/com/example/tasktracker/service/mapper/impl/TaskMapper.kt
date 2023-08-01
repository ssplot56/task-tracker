package com.example.tasktracker.service.mapper.impl

import com.example.tasktracker.model.Task
import com.example.tasktracker.model.dto.TaskRequestDto
import com.example.tasktracker.model.dto.TaskResponseDto
import com.example.tasktracker.service.UserService
import com.example.tasktracker.service.mapper.RequestDtoMapper
import com.example.tasktracker.service.mapper.ResponseDtoMapper
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TaskMapper(
    val userService: UserService
) : RequestDtoMapper<TaskRequestDto, Task>,
    ResponseDtoMapper<TaskResponseDto, Task> {
    override fun mapToModel(dto: TaskRequestDto): Task {
        return Task(
            null,
            dto.content,
            LocalDateTime.now(),
            false,
            userService.findById(dto.userId))
    }

    override fun mapToDto(entity: Task): TaskResponseDto {
        return TaskResponseDto(
            entity.id!!,
            entity.content,
            entity.updateDate,
            entity.isFinished,
            entity.user.id!!)
    }
}