package com.psawesome.chapter5

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.ServerResponse.status

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 22:54
 */
@Component
class CustomerHandler(private val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) =
            customerService.getCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())

}