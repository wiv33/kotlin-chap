package com.psawesome.microtest

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.util.AssertionErrors.assertEquals
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * package: com.psawesome.microtest
 * author: PS
 * DATE: 2020-01-17 금요일 23:27
 */

@WebFluxTest(CustomerController::class)
@RunWith(SpringRunner::class)
class CustomerControllerTest {

    @Autowired
    lateinit var testClient: WebTestClient

    @MockBean
    lateinit var service: CustomerServiceImpl

    @Test
    fun `get customer 1`() {
        given(service.getCustomer(1)).willReturn(Mono.just(Customer(1, "Kotlin")))

        val responseBody = testClient
                .get()
                .uri("/customer/{id}", 1)
                .exchange()
                .expectStatus().isOk
                .expectBody(Customer::class.java)
                .returnResult().responseBody

        assertEquals("ID check", 1, responseBody?.id)
        assertEquals("NAME Check", "Kotlin", responseBody?.name)
    }

    @Test
    fun `get customers`() {
        given(service.getAllCustomers()).willReturn(Flux.just(
                Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Webflux"))
        )

        val responseBody = testClient.get()
                .uri("/customers")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectBodyList(Customer::class.java)
                .hasSize(3)
                .returnResult().responseBody

        assertEquals("ID check", 1, responseBody?.get(0)?.id)
    }
}