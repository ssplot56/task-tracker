package com.example.tasktracker.service.impl

import com.example.tasktracker.model.Task
import com.example.tasktracker.repository.TaskRepository
import com.example.tasktracker.service.TaskService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TaskServiceImpl(
    val taskRepository: TaskRepository
) : TaskService {
    override fun save(task: Task): Task {
        return taskRepository.save(task)
    }

    override fun update(id: Long, task: Task): Task {
        val taskInDb = findById(id)
        taskInDb.content = task.content
        taskInDb.updateDate = LocalDateTime.now()
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

    override fun changeTaskStatus(id: Long): Task {
        val taskForChange = findById(id)
        taskForChange.isFinished = !taskForChange.isFinished
        taskForChange.updateDate = LocalDateTime.now()
        return taskRepository.save(taskForChange)
    }
}