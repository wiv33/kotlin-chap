package com.psawesome.chapter03

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class Chapter03Application

fun main(args: Array<String>) {
    runApplication<Chapter03Application>(*args)
}
