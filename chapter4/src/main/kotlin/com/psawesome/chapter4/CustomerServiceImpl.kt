package com.psawesome.chapter4

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(
                Customer(1, "kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Micro", Customer.Telephone("+82", "10238472523"))
        )
    }
    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int) = customers[id]?.toMono() ?: Mono.empty()

    override fun searchCustomers(nameFilter: String) = customers.filter {
        println(it)
        println("${it.key} : ${it.value}, ${it.value.name}")
        it.value.name.contains(nameFilter, true)
    }.map(Map.Entry<Int, Customer>::value).toFlux()

    override fun createCustomer(customerMono: Mono<Customer>) =
            customerMono.flatMap {
                if (customers[it.id] == null) {
                    customers[it.id] = it
                    it.toMono()
                } else {
                    Mono.error(CustomerExistException("Customer ${it.id} already exist"))
                }
            }
}