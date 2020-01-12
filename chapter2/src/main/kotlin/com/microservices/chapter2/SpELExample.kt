package com.microservices.chapter2

import org.springframework.beans.factory.annotation.Value

/**
package: com.microservices.chapter2
author: PS
DATE: 2020-01-12 일요일 23:58
 */
class SpELExample {

    // result1의 값은 7
    @Value(value = "#{4+3}")
    private lateinit var result1 : Number

    // one.value 나누기 another.value
    @Value(value = "#{ \${one.value} div \${another.value} }")
    private lateinit var result2: Number

    // one.value와 another.value 가 같다면 true
    @Value(value = "#{ \${one.value} eq \${another.value} }")
    private lateinit var result3: Comparable<Boolean>

    // one.value와 another.value이어야 한다
    @Value(value = "#{ \${one.value} and \${another.value} }")
    private lateinit var result4: Comparable<Boolean>

    // 이 값은 변수가 설정에 없으면 값이 hello로 설정된다.
    @Value(value = "\${service.message.simple:hello}")
    private lateinit var result5: String

    // some.value가 영어 또는 숫자이면 true
    @Value(value = "#{ '\${some.value}' matches '[a-zA-Z\\s]+'}")
    private lateinit var result6: Comparable<Boolean>

    constructor(result1: Number, result2: Number, result3: Comparable<Boolean>, result4: Comparable<Boolean>, result5: String, result6: Comparable<Boolean>) {
        this.result1 = result1
        this.result2 = result2
        this.result3 = result3
        this.result4 = result4
        this.result5 = result5
        this.result6 = result6
        println("result1 = $result1")
        println("result2 = $result2")
        println("result3 = $result3")
        println("result4 = $result4")
        println("result5 = $result5")
        println("result6 = $result6")
    }

}