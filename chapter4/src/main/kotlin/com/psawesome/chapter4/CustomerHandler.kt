package com.psawesome.chapter4

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 22:03
 */
@Component
class CustomerHandler {
    fun get(ServerRequest: ServerRequest): Mono<ServerResponse> {
        return ok().body(Customer(1, "functional web").toMono(), Customer::class.java)
    }
}