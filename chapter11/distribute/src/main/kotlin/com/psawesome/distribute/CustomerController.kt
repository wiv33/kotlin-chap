package com.psawesome.distribute

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

/**
package: com.psawesome.distribute
author: PS
DATE: 2020-01-18 토요일 17:47
 */
@RestController
class CustomerController {
    companion object {
        private val initCustomers = arrayOf(Customer(1, "kotlin"), Customer(2, "Flux"), Customer(3, "Mono"))
        val customers = ConcurrentHashMap<Int, Customer>(initCustomers.associateBy(Customer::id))
    }

    @GetMapping("/customers")
    fun getCustomers() = customers.values.toList()

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customers[id]
}