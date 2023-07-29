package com.example.tasktracker.service.mapper

interface RequestDtoMapper<K, T> {
    fun mapToModel(dto: K) : T
}