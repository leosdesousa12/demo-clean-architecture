package com.br.user.registration.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("com.br.user.registration.demo")
class Boot {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<Boot>(*args)
        }
    }
}