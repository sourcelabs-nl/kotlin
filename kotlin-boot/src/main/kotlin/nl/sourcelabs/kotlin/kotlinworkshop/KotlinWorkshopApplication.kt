package nl.sourcelabs.kotlin.kotlinworkshop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinWorkshopApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinWorkshopApplication::class.java, *args)
}
