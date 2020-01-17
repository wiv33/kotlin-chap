package com.psawesome.microtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroTestApplication

fun main(args: Array<String>) {
	runApplication<MicroTestApplication>(*args)
}
