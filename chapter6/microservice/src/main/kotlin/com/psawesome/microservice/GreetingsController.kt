package com.psawesome.microservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
package: com.psawesome.microservice
author: PS
DATE: 2020-01-16 목요일 22:03
 */
@RestController
class GreetingsController {

    @Value("\${microservice.example.greetings}")
    private lateinit var greetings: String

    @GetMapping("/greetings")
    fun greetings() = greetings

}