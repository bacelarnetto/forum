package br.com.bacel.forum.repository

import br.com.bacel.forum.model.Curso
import br.com.bacel.forum.model.Resposta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RespostaRepository : JpaRepository<Resposta, Long>{

}