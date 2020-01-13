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
    private lateinit var customerService: CustomerService

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(id)

    @PostMapping("/customer")
    fun createCustomer(@RequestBody customer: Customer) = customerService.createCustomer(customer)

    @DeleteMapping("/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int) = customerService.deleteCustomer(id)

    @PutMapping("/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer) = customerService.updateCustomer(id, customer)

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) = customerService.searchCustomer(nameFilter)
}