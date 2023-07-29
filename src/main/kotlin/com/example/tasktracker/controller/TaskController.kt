package com.example.tasktracker.controller

import com.example.tasktracker.model.dto.TaskRequestDto
import com.example.tasktracker.model.dto.TaskResponseDto
import com.example.tasktracker.service.TaskService
import com.example.tasktracker.service.mapper.impl.TaskMapper
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/tasks")
class TaskController(
    val taskService: TaskService,
    val taskMapper: TaskMapper
) {
    @PostMapping
    fun save(@RequestBody requestDto: TaskRequestDto) : TaskResponseDto {
        return taskMapper.mapToDto(taskService.save(taskMapper.mapToModel(requestDto)))
    }

    @GetMapping
    fun findAll() : List<TaskResponseDto> {
        return taskService.findAll()
            .map { task -> taskMapper.mapToDto(task) }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) : TaskResponseDto {
        return taskMapper.mapToDto(taskService.findById(id))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) {
        taskService.deleteById(id)
    }
}