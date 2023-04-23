package br.com.bacel.forum.repository

import br.com.bacel.forum.dto.TopicoPorCategoriaDto
import br.com.bacel.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository : JpaRepository<Topico, Long>{

    fun findByCursoNome(nomeCurso : String, paginacao : Pageable): Page<Topico>
    @Query("SELECT new br.com.bacel.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t)) FROM Topico t JOIN t.curso curso GROUP BY curso.categoria")
    fun getRelatorio(): List<TopicoPorCategoriaDto>
}