package com.psawesome.chapter03

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

/**
package: com.psawesome.chapter03
author: PS
DATE: 2020-01-13 월요일 21:06
 */
@RestController
class CustomerController {

    @Autowired
    lateinit var customers: ConcurrentHashMap<Int, Customer>

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customers[id]

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer: Customer) {
        customers[customer.id] = customer
    }

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int) = customers.remove(id)

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer) {
        customers.remove(id)
        customers[customer.id] = customer
    }

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            customers.filter { it.value.name.contains(nameFilter, true) }
                    .map(Map.Entry<Int, Customer>::value).toList()
}