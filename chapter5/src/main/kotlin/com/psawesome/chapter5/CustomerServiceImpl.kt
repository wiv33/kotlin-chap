package com.psawesome.chapter5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 22:50
 */
@Service
class CustomerServiceImpl: CustomerService {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override fun getCustomer(id: Int) = customerRepository.findById(id)
    override fun createCustomer(customer: Mono<Customer>) = customerRepository.create(customer)
    override fun deleteCustomer(id: Int) = customerRepository.deleteById(id).map { it.deletedCount > 0 }
    override fun searchCustomers(nameFilter: String) = customerRepository.searchCustomers(nameFilter)

}