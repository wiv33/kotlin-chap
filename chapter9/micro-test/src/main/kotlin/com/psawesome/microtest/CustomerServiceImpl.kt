package com.psawesome.microtest

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

/**
package: com.psawesome.microtest
author: PS
DATE: 2020-01-17 금요일 22:50
 */
@Service
class CustomerServiceImpl: CustomerService {

    companion object {
        private val initCustomers = arrayOf(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Webflux")
        )
        private val customers = ConcurrentHashMap<Int, Customer>(initCustomers.associateBy(Customer::id))
    }

    override fun getCustomer(id: Int): Mono<Customer> = customers[id]?.toMono() ?: Mono.empty()

    override fun getAllCustomers() = customers.map(Map.Entry<Int, Customer>::value).toFlux()
}