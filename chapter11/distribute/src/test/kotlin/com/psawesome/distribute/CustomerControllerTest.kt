package com.psawesome.distribute

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * package: com.psawesome.distribute
 * author: PS
 * DATE: 2020-01-18 토요일 17:52
 */
@RunWith(SpringRunner::class)
@AutoConfigureMockMvc
@SpringBootTest
class CustomerControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `we should get the customer list`() {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$[0].id").value(1))
                .andExpect(jsonPath("\$[0].name").value("kotlin"))
                .andExpect(jsonPath("\$[1].id").value(2))
                .andExpect(jsonPath("\$[1].name").value("Flux"))
                .andExpect(jsonPath("\$[2].id").value(3))
                .andExpect(jsonPath("\$[2].name").value("Mono"))
                .andDo(print())
    }

    @Test
    fun `we should get a customer by id`() {
        mockMvc.perform(get("/customer/{id}", 1))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$.id").value(1))
                .andExpect(jsonPath("\$.name").value("kotlin"))
                .andDo(print())
    }

}