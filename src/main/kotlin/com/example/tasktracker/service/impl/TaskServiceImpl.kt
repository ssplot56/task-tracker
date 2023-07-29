package com.example.tasktracker.service.impl

import com.example.tasktracker.model.Task
import com.example.tasktracker.repository.TaskRepository
import com.example.tasktracker.service.TaskService
import org.springframework.stereotype.Service

@Service
class TaskServiceImpl(
    val taskRepository: TaskRepository
) : TaskService {
    override fun save(task: Task): Task {
        return taskRepository.save(task)
    }

    override fun findById(id: Long): Task {
        return taskRepository.findById(id).get()
    }

    override fun findAll(): List<Task> {
        return taskRepository.findAll()
    }

    override fun deleteById(id: Long) {
        taskRepository.deleteById(id)
    }
}