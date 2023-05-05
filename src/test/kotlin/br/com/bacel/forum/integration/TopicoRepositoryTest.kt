package br.com.bacel.forum.integration

import br.com.bacel.forum.configuration.DatabaseContainerConfiguration
import br.com.bacel.forum.dto.TopicoPorCategoriaDto
import br.com.bacel.forum.model.TopicoTest
import br.com.bacel.forum.repository.TopicoRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.data.domain.PageRequest
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TopicoRepositoryTest : DatabaseContainerConfiguration() {

    @Autowired
    private lateinit var topicoRepository: TopicoRepository

    private val paginacao = PageRequest.of(0,5)
    private val topico = TopicoTest.build()


    @Test
    fun `deve deve gerar um relarotio`(){
        topicoRepository.save(topico)
        var relatorio = topicoRepository.getRelatorio()
        assertThat(relatorio).isNotEmpty.isNotNull
        assertThat(relatorio.first()).isExactlyInstanceOf(TopicoPorCategoriaDto::class.java)
    }

    @Test
    fun `deve buscar um topico por nome`() {
        topicoRepository.save(topico)
        val resultado = topicoRepository.findByCursoNome(nomeCurso = "Kotlin", paginacao = paginacao)
        assertThat(resultado.totalElements).isEqualTo(1)
    }

}