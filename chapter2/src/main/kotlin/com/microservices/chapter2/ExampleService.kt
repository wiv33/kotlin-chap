package com.microservices.chapter2

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
package: com.microservices.chapter2
author: PS
DATE: 2020-01-12 일요일 20:33
 */
@Service
class ExampleService : ServiceInterface {
    // lateinit은 생성자 다음에 초기화 한다는 것을 의미
    @Value(value = "\${service.message.text}")
    private lateinit var text: String

    override fun getHello(name: String) = "$text $name"
}