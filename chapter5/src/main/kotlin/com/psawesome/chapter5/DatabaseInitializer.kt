package com.psawesome.chapter5

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
    lateinit var mongoOperations: ReactiveMongoOperations

    @PostConstruct
    fun initData() {
        mongoOperations.collectionExists("Customers").subscribe {
            if (it != true)
                mongoOperations.createCollection("Customers").subscribe {
                    println("Customers collections created")
                } else println("Customers collections already exist")
        }
    }
}