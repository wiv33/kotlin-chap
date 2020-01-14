package com.psawesome.chapter4

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.router

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 21:54
 */

/*
    RouterFunction
    응답하는 경로와 처리할 메서드의 정의
*/
@Component
class CustomerRouter(private val customerHandler: CustomerHandler) {
    /**
    *   RouterFunction
    *   DSL (Domain Specific Language)
    *
    *   https://kotlinlang.org/docs/reference/typesafe-builders.html
    *
    * */
    @Bean
    fun customerRoutes(): RouterFunction<*> = router {
        "/functional".nest {
            "/customer".nest {
                GET("/{id}", customerHandler::get)
                POST("/", customerHandler::create)
            }
            "/customers".nest {
                GET("/", customerHandler::search)
            }
        }
    }
}
