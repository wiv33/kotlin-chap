package com.psawesome.microtest

import org.junit.Test

import org.junit.Assert.*
import org.springframework.beans.factory.annotation.Autowired

/**
 * package: com.psawesome.microtest
 * author: PS
 * DATE: 2020-01-17 금요일 23:18
 */
class CustomerServiceTest : MicroTestApplicationTests() {

    @Autowired
    lateinit var customerService: CustomerService

    @Test
    fun `we should get a customer with a valid id`() {
        val customer = customerService.getCustomer(1)
        assertEquals(1, customer.block()?.id)
    }

    @Test
    fun `we should get all customers`() {
        val allCustomers = customerService.getAllCustomers()
        assertEquals(3, allCustomers.count().block()?.toInt())
    }
}