package br.com.bacel.forum.model

import br.com.bacel.forum.dto.TopicoView
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset

object TopicoViewTest {
    fun build() = TopicoView(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        status = StatusTopico.NAO_RESPONDIDO,
        dataCriacao = LocalDateTime.now(),
        dataAlteracao = LocalDateTime.now()
    )
}