package com.psawesome.chapter5

import org.springframework.data.mongodb.core.mapping.Document

/**
package: com.psawesome.chapter5
author: PS
DATE: 2020-01-15 수요일 21:05
 */
@Document
data class Customer (var id: Int = 0, var name: String = "", var telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}