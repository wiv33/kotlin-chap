package com.microservices.chapter2

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

/**
package: com.microservices.chapter2
author: PS
DATE: 2020-01-12 일요일 21:06
 */
@Service
interface ServiceInterface {
    fun getHello(name: String): String
}