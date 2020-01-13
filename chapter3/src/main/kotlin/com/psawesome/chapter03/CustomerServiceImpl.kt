package com.psawesome.chapter03

import com.psawesome.chapter03.Customer.*
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers =
                arrayOf(Customer(1, "kotlin", Telephone("+44", "23809423")),
                        Customer(2, "Spring"),
                        Customer(3, "micro",Telephone("+82", "10284208523")))
    }

    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int): Customer? = customers[id]

    override fun createCustomer(customer: Customer) {
        customers[customer.id] = customer
    }

    override fun deleteCustomer(id: Int) {
        customers.remove(id)
    }

    override fun updateCustomer(id: Int, customer: Customer) {
        deleteCustomer(id)
        createCustomer(customer)
    }

    override fun searchCustomer(nameFilter: String): List<Customer> =
            customers.filter { it.value.name.contains(nameFilter, true) }
            .map(Map.Entry<Int, Customer>::value).toList()
}