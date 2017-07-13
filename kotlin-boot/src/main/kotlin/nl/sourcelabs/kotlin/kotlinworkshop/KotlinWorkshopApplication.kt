package nl.sourcelabs.kotlin.kotlinworkshop

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinWorkshopApplication {

//    @Bean
//    fun mapper() = Jackson2ObjectMapperBuilder().modulesToInstall(KotlinModule(), JavaTimeModule()).dateFormat(ISO8601DateFormat())
}

fun main(args: Array<String>) {
    SpringApplication.run(KotlinWorkshopApplication::class.java, *args)
}
