package com.psawesome.microservices

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

/**
package: com.psawesome.microservices
author: PS
DATE: 2020-01-17 금요일 21:19
 */
@RestController
class HelloController {
    private val id:String = UUID.randomUUID().toString()

    companion object {
        val total: AtomicInteger = AtomicInteger()
    }

    @GetMapping("/hello")
    fun myHello() = Mono.just("Hello I', $id and I have been called ${total.incrementAndGet()} time(s)")

}