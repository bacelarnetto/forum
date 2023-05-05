package br.com.bacel.forum.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.io.Serializable
import javax.persistence.*

@Entity
data class Usuario (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val email: String,
    val password: String,
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_role")
    val role: List<Role> = mutableListOf()
): Serializable
