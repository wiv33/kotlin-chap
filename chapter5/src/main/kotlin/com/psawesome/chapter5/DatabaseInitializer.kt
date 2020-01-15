package com.psawesome.chapter5

import com.psawesome.chapter5.Customer.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 20:58
 */
@Component
class DatabaseInitializer {

    @Autowired
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var mongoOperations: ReactiveMongoOperations

    companion object {
        val initialCustomers = listOf(
                Customer(1, "kotlin"),
                Customer(2, "Flux"),
                Customer(3, "Mono", Telephone("+82", "102572934")))
    }

    @PostConstruct
    fun initData() {
        mongoOperations.collectionExists("Customers").subscribe {
            if (it != true)
                mongoOperations.createCollection("Customers").subscribe {
                    println("Customers collections created")
                } else println("Customers collections already exist")
            customerRepository.saveAll(initialCustomers).subscribe{
                println("Default customers created")
            }
        }
    }
}