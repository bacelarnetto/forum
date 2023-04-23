package br.com.bacel.forum.repository

import br.com.bacel.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository : JpaRepository<Topico, Long>{

    fun findByCursoNome(nomeCurso : String, paginacao : Pageable): Page<Topico>
}