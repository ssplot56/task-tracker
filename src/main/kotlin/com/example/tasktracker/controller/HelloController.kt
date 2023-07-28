package com.example.tasktracker.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloController {

    @GetMapping
    fun printHello(): String {
        return "hello, Kotlin controller works!"
    }
}