package com.psawesome.chapter4

import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono
import org.springframework.web.reactive.function.server.ServerResponse.ok

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 21:54
 */
@Component
class CustomerRouter {
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
                GET("/") {
                    ok().body(Customer(5, "functional web").toMono(), Customer::class.java)
                }
            }
        }
    }
}
