package br.com.bacel.forum.service

import br.com.bacel.forum.model.Curso
import br.com.bacel.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.Arrays

@Service
class CursoService(private val cursoRepository: CursoRepository) {

    fun buscarPorId(id: Long): Curso{
        return cursoRepository.getReferenceById(id)
    }

}
