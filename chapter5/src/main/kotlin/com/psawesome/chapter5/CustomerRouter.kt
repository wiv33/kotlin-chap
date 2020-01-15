package com.psawesome.chapter5

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 22:57
 */
@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {

    @Bean
    fun customerRoutes() = router {
        "/customer".nest {
            GET("/{id}", customerHandler::get)
        }
    }
}