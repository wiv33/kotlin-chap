package com.psawesome.chapter5

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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

}