package br.com.bacel.forum.model

import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
data class Resposta (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    val mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC),
    @ManyToOne
    val autor: Usuario,
    @ManyToOne
    val topico: Topico,
    val solucao: Boolean
): Serializable
