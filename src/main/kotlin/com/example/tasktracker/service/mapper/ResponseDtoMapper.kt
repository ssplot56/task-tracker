package com.example.tasktracker.service.mapper

interface ResponseDtoMapper<K, T> {
    fun mapToDto(entity: T) : K
}