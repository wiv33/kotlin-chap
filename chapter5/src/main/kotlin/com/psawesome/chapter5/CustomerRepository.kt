package com.psawesome.chapter5

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 21:28
 */
/*
    ReactiveMongoTemplate
        ReactiveMongoOperations를 상속한 클래스
    Mono, Flux를 사용하기 위해 ReactiveMongoTemplate을 상속하고,
    @Repository 추가
 */
@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate) {
    companion object {
        val initialCustomers = listOf(
                Customer(1, "kotlin"),
                Customer(2, "Flux"),
                Customer(3, "Mono", Customer.Telephone("+82", "102572934")))
    }

    @PostConstruct
    fun initializeRepository() = initialCustomers
            .map(Customer::toMono)
            .map(this::create)
            .map(Mono<Customer>::subscribe)

    fun create(customer: Mono<Customer>) = template.save(customer)
    fun findById(id: Int) = template.findById<Customer>(id)
    fun deleteById(id: Int) = template.remove(query(where("_id").isEqualTo(id)))
    fun searchCustomers(nameFilter: String) = template.find<Customer>(query(where("name").regex(".*$nameFilter.*", "i")))
}