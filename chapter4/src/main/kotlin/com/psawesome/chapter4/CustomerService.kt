package com.psawesome.chapter4

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 21:10
 */
interface CustomerService {
    fun getCustomer(id: Int): Customer?
    fun searchCustomers(nameFilter: String): List<Customer>
}