package nl.sourcelabs.instructor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert
import org.junit.Test

class Message(val message: String)

class MessageConverter {

    val objectMapper = ObjectMapper().registerModule(KotlinModule())!!

    /**
     * Version without the reified generics, we need to pass the type Class because
     * the T (type) info is not usable at runtime due to type erasure.
     */
    fun <T> convert(jsonMessage: String, clazz: Class<T>): T {
        return objectMapper.readValue(jsonMessage, clazz)
    }

    /**
     * Instead of passing the class we add the <reified T> to the function declaration.
     * Now the compiler can reify the type for the convert at the invocation point.
     * Note that this only works for inline functions!
     */
    inline fun <reified T> convert(jsonMessage: String): T {
        return objectMapper.readValue(jsonMessage, T::class.java)
    }
}

class MessageHandlerTest {

    @Test
    fun testHandleMessage() {
        val jsonString = """{ "message": "Hello world!" }"""

        val m = MessageConverter().convert(jsonString, Message::class.java)

        Assert.assertEquals("Hello world!", m.message)
    }

    @Test
    fun testHandleMessageWithReified() {
        val jsonString = """{ "message": "Hello world!" }"""

        val m = MessageConverter().convert<Message>(jsonString)

        Assert.assertEquals("Hello world!", m.message)
    }
}