package br.com.bacel.forum.service

import br.com.bacel.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuarios: List<Usuario>) {
    init {
        var autor = Usuario(
            id = 1,
            nome = "Ana Paula",
            email = "ana.paula@gmail.com"
        )
        usuarios = Arrays.asList(autor)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios.stream().filter({
                c -> c.id == id
        }).findFirst().get()
    }

}