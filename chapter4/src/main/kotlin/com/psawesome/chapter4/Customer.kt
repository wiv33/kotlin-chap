package com.psawesome.chapter4

/**
package: com.psawesome.chapter4
author: PS
DATE: 2020-01-14 화요일 20:26
 */
data class Customer(var id: Int = 0, val name: String = "", val telephone: Telephone? = null) {
    data class Telephone(var countryCode: String = "", var telephoneNumber: String = "")
}