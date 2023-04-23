package br.com.bacel.forum.service

import br.com.bacel.forum.model.Usuario
import br.com.bacel.forum.repository.UsuarioRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.getReferenceById(id)
    }

}