package br.com.bacel.forum.config

import io.undertow.server.DefaultByteBufferPool
import io.undertow.websockets.jsr.WebSocketDeploymentInfo
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

@Configuration
class UndertowCustomizationConfig : WebServerFactoryCustomizer<UndertowServletWebServerFactory> {

    override fun customize(factory: UndertowServletWebServerFactory) {
        factory.addDeploymentInfoCustomizers({ deploymentInfo ->
            val webSocketDeploymentInfo = WebSocketDeploymentInfo()
            webSocketDeploymentInfo.buffers = DefaultByteBufferPool(false, 1024)
            deploymentInfo.addServletContextAttribute(
                "io.undertow.websockets.jsr.WebSocketDeploymentInfo",
                webSocketDeploymentInfo
            )
        })
    }
}