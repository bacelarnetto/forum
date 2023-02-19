package br.com.bacel.forum.service

import br.com.bacel.forum.model.Curso
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService(var cursos: List<Curso>) {
    init {
        var curso = Curso(
            id = 1,
            nome = "Kotlin",
            categoria = "Programação"
        )
        cursos = Arrays.asList(curso)
    }

    fun buscarPorId(id: Long): Curso{
        return cursos.stream().filter({
            c -> c.id == id
        }).findFirst().get()
    }

}
