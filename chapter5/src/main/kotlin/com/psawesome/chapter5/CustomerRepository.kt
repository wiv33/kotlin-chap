package com.psawesome.chapter5

import org.springframework.data.repository.reactive.ReactiveCrudRepository

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 21:28
 */
interface CustomerRepository : ReactiveCrudRepository<Customer, Int>