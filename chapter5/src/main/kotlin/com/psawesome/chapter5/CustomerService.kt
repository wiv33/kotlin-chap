package com.psawesome.chapter5

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 22:49
 */
interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun createCustomer(customer: Mono<Customer>): Mono<Customer>
    fun deleteCustomer(id: Int): Mono<Boolean>
    fun searchCustomers(nameFilter: String): Flux<Customer>
}