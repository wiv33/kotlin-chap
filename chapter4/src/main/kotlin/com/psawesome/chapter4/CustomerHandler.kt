package com.psawesome.chapter4


import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 22:03
 */
@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) = ok().body(customerService.getCustomer(serverRequest.pathVariable("id").toInt()))
            .flatMap { ok().body(fromObject(it)) }
            .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())
//    같은 기능 다른 구현
//            .switchIfEmpty(notFound().build())
}