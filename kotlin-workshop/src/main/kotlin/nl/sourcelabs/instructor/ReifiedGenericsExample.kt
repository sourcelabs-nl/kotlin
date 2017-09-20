package nl.sourcelabs.instructor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

class MessageEnvelope(val payload: String)

class MessageHandler<T> {

    val objectMapper = ObjectMapper().registerModule(KotlinModule())

    // Does not work because of type erasure
//  fun handleMessage(message: MessageEnvelope): T {
//      return objectMapper.readValue(message.payload, T::class.java)
//  }

    // Does work because all of the type information is in the inline function call
    inline fun <reified R> handleMessage(message: MessageEnvelope): R {
        return objectMapper.readValue(message.payload, R::class.java)
    }
}

class Message(val message: String)

fun main(args: Array<String>) {
    val messageEnvelope = MessageEnvelope(payload = """{ "message": "Hello world!" }""")

    // Does not work because type is not specified for m
//  val m = MessageHandler<Message>().handleMessage(messageEnvelope)

    // Works because type can be reified from m
    val m: Message = MessageHandler<Message>().handleMessage(messageEnvelope)

    println(m.message)
}