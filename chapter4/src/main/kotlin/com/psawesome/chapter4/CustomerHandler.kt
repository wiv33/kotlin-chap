package com.psawesome.chapter4


import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.publisher.onErrorResume
import java.net.URI

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 22:03
 */
/*
    Handler
    구체적인 요청을 응답으로 변환하는 로직을 수행
*/
@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) =
            customerService.getCustomer(serverRequest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())

    //    같은 기능 다른 구현
//            .switchIfEmpty(notFound().build())
    fun search(serverRequest: ServerRequest) =
            /*
                queryParam의 반환은 Optional<String!>, orElse("")로 Optional 을 벗긴다.
                java optional과 동일 / 반환된 Optional 객체의 value가 Null일 경우 other로 정의한 "" 상태를 반환하도록 한다.
            */
            ok().body(customerService.searchCustomers(serverRequest.queryParam("nameFilter").orElse("")), Customer::class.java)

    fun create(serverRequest: ServerRequest) =
            customerService.createCustomer(serverRequest.bodyToMono())
                    .flatMap { created(URI.create("/functional/customer/${it.id}")).build() }
                    .onErrorResume(Exception::class) {
                        badRequest().body(fromObject(ErrorResponse("error", it.message ?: "error")))
                    }
                    /*.onErrorResume(Exception::class, fun(_: Exception): Mono<ServerResponse> {
                        return badRequest().body(fromObject("error"))
                    })*/
}