package com.psawesome.chapter4

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 21:10
 */
/*
    도메인의 비즈니스 로직을 수행 (캡슐화)
*/
interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun searchCustomers(nameFilter: String): Flux<Customer>
    fun createCustomer(customerMono: Mono<Customer>): Mono<*>
}