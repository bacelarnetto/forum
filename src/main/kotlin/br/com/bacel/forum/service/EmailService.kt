package br.com.bacel.forum.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(
    private val javaMailSender: JavaMailSender
)  {
    fun notificar(autor :String) {
        val message = SimpleMailMessage()

        message.setSubject("Resposta Recebida!")
        message.setText("Ola, o seu tópico foi respondido. Vamos la conferir?")
        message.setTo(autor)

        javaMailSender.send(message)
    }
}