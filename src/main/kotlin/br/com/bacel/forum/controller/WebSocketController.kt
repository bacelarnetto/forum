package br.com.bacel.forum.controller

import org.springframework.core.NestedExceptionUtils
import org.springframework.messaging.handler.annotation.MessageExceptionHandler
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.util.Assert


@Controller
class WebSocketController {

    @MessageExceptionHandler
    @SendTo("/topic/errors")
    fun handleException(e: IllegalArgumentException?): String? {
        val message = "an exception occurred! " + NestedExceptionUtils.getMostSpecificCause(e!!)
        println(message)
        return message
    }

    @MessageMapping("/chat")
    @SendTo("/topic/greetings")
    @Throws(Exception::class)
    fun greet(request: GreetingRequest): GreetingResponse? {
        Assert.isTrue(
            Character.isUpperCase(request.name[0])
        ) { "the name must start with a capital letter!" }
        Thread.sleep(1000)
        return GreetingResponse("Hello, " + request.name)
    }

    @MessageMapping("/news")
    @SendTo("/topic/news")
    fun broadcastNews(@Payload message: String): String {
        return message
    }
}
data class GreetingResponse(val content: String)
data class GreetingRequest(val name: String)