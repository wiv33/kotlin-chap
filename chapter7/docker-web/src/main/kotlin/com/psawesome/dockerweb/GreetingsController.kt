package com.psawesome.dockerweb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

/**
package: com.psawesome.dockerweb
author: PS
DATE: 2020-01-17 금요일 00:24
 */
@RestController
class GreetingsController {

    @GetMapping("/greetings")
    fun greetings() = Mono.just("hello from a Docker!!!!")
}