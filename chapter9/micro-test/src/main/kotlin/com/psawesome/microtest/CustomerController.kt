package com.psawesome.microtest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

/**
package: com.psawesome.microtest
author: PS
DATE: 2020-01-17 금요일 22:46
 */
@RestController
class CustomerController {

    @Autowired
    lateinit var customerService: CustomerService

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customerService.getCustomer(id)

    @GetMapping("/customers")
    fun getAllCustomers() = customerService.getAllCustomers()
}