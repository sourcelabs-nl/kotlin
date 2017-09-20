package nl.sourcelabs.instructor

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Test
import org.testng.Assert

val objectMapper = ObjectMapper().registerModule(KotlinModule())

/**
 * Some message envelope containing a json payload.
 */
class MessageEnvelope(val payload: String)

/**
 * Representation of the json message payload.
 */
class Message(val message: String)

/**
 * Broken version without the reified generics
 * Does not work because the type information on the class is not
 * available at runtime due to type erasure.
 */
//class MessageHandler<out T> {
//
//    // Does not work because of type erasure
//    fun handleMessage(message: MessageEnvelope): T {
//        return objectMapper.readValue(message.payload, T::class.java)
//    }
//}

/**
 * Instead of defining the type on the class we add the <reified T> to handleMessage.
 * Now the compiler can reify the type for the handleMessage at the invocation point.
 */
class MessageHandler {

    // Does work because all of the type information is in the inline function call
    inline fun <reified T> handleMessage(message: MessageEnvelope): T {
        return objectMapper.readValue(message.payload, T::class.java)
    }
}

class MessageHandlerTest {
    @Test
    fun testHandleMessage() {
        val messageEnvelope = MessageEnvelope(payload = """{ "message": "Hello world!" }""")
        // We need to explicitly define the type for m otherwise the compiler cannot reify it!
        val m: Message = MessageHandler().handleMessage(messageEnvelope)

        Assert.assertEquals("Hello world!", m.message)
    }
}