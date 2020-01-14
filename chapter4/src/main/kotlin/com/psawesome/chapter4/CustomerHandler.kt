package com.psawesome.chapter4

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok


import reactor.core.publisher.Mono

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 22:03
 */
@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(ServerRequest: ServerRequest) = ok().body(customerService.getCustomer(1), Customer::class.java)

}