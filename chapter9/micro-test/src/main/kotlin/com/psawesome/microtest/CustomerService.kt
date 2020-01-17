package com.psawesome.microtest

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
package: com.psawesome.microtest
author: PS
DATE: 2020-01-17 금요일 22:48
 */
interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun getAllCustomers(): Flux<Customer>
}