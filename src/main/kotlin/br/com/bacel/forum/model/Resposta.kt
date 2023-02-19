package br.com.bacel.forum.model

import java.time.LocalDateTime

data class Resposta (
    val id:Long? = null,
    val maensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(),
    val autor:Usuario,
    val topico: Topico,
    val solucao: Boolean
)
