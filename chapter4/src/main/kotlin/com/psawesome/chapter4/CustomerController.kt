package com.psawesome.chapter4

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 20:29
 */
@RestController
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Mono<Customer>> {
        return ResponseEntity(Customer(id, "Customer $id").toMono(), HttpStatus.OK)
    }

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String) =
            customerService.searchCustomers(nameFilter)


}