package com.psawesome.chapter03

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.context.annotation.Bean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.client.RestTemplate

/**
 * package: com.psawesome.chapter03
 * author: PS
 * DATE: 2020-01-13 월요일 21:10
 */
@SpringBootTest
@RunWith(SpringRunner::class)
class CustomerControllerTest {

    var restTemplate: RestTemplate = RestTemplate()

    @Test
    fun getCustomer(){
        val forObject = restTemplate.getForObject("http://localhost:8080/customer", String::class.java)
        println(forObject)
    }

}

