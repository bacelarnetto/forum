package br.com.bacel.forum.model

import java.io.Serializable
import java.time.LocalDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
data class Topico (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var titulo: String,
    var mensagem: String,
    val dataCriacao: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC),
    var dataAlteracao: LocalDateTime? = null,
    @ManyToOne
    val curso: Curso,
    @ManyToOne
    val autor: Usuario,
    @Enumerated(value = EnumType.STRING)
    val status: StatusTopico,
    @OneToMany(mappedBy = "topico")
    val respostas: List<Resposta> = ArrayList()
 ): Serializable


