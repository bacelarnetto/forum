package br.com.bacel.forum.dto

import br.com.bacel.forum.model.StatusTopico
import java.io.Serializable
import java.time.LocalDateTime

data class RespostaView(
    val id: Long?,
    val mensagem: String,
    val dataCriacao: LocalDateTime,
    val solucao: Boolean,
    val tituloTopico: String,
    val autor: String
) : Serializable