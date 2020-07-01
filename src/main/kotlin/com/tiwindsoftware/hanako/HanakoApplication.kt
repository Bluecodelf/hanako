package com.tiwindsoftware.hanako

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HanakoApplication

fun main(args: Array<String>) {
    runApplication<HanakoApplication>(*args)
}
