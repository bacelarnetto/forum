package br.com.bacel.forum.service

import br.com.bacel.forum.model.Usuario
import br.com.bacel.forum.repository.UsuarioRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service


@Service
class UsuarioService(
    private val usuarioRepository: UsuarioRepository
): UserDetailsService {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val usuario = usuarioRepository.findByEmail(username) ?: throw RuntimeException()
        return UserDetails(usuario)
    }

}
