package com.psawesome.chapter03

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.*

/**
package: com.psawesome.chapter03
author: PS
DATE: 2020-01-13 월요일 21:07
 */
//@JsonInclude(Include.NON_NULL) // yml 설정
data class Customer(var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}
