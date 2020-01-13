package com.psawesome.chapter03

/**
package: com.psawesome.chapter03
author: PS
DATE: 2020-01-13 월요일 22:14
 */
interface CustomerService {
    fun getCustomer(id: Int) : Customer?
    fun createCustomer(customer: Customer)
    fun deleteCustomer(id: Int)
    fun updateCustomer(id: Int, customer: Customer)
    fun searchCustomer(nameFilter: String): List<Customer>
}