package br.com.bacel.forum.model

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Role (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val nome: String
): GrantedAuthority{
    override fun getAuthority() = nome

}
