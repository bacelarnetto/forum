package br.com.bacel.forum.service

import br.com.bacel.forum.mapper.TopicoFormMapper
import br.com.bacel.forum.mapper.TopicoViewMapper
import br.com.bacel.forum.model.Topico
import br.com.bacel.forum.model.TopicoTest
import br.com.bacel.forum.model.TopicoViewTest
import br.com.bacel.forum.repository.TopicoRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import br.com.bacel.forum.exception.NotFoundException
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import java.util.Optional

class TopicoServiceTest {

    private val topico = TopicoTest.build()
    private val topicoView = TopicoViewTest.build()

    private val pages = PageImpl(listOf(topico))

    private val pageable: Pageable = mockk()
    private val topicoViewMapper: TopicoViewMapper = mockk()
    private val topicoFormMapper: TopicoFormMapper = mockk()

    private val topicoRepository: TopicoRepository = mockk {
        every { findAll(pageable) } returns pages
        every { findByCursoNome(any(), any()) } returns pages
    }

    private val topicoService = TopicoService(
        topicoRepository = topicoRepository,
        topicoViewMapper = topicoViewMapper,
        topicoFormMapper = topicoFormMapper
    )

    @Test
    fun `deve listar topico por nome do curso`() {
        val slot = slot<Topico>()
        every {
            topicoViewMapper.map(capture(slot))
        } returns topicoView

        topicoService.listar("Kotlin Basico", pageable)

        verify(exactly = 0) { topicoRepository.findAll(pageable) }
        verify(exactly = 1) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }

        assertThat(slot.captured.titulo).isEqualTo(topico.titulo)
        assertThat(slot.captured.mensagem).isEqualTo(topico.mensagem)
        assertThat(slot.captured.status).isEqualTo(topico.status)
    }

    @Test
    fun `deve listar todos os topicos quando nome do curso for nulo`() {
        val slot = slot<Topico>()
        every { topicoViewMapper.map(capture(slot)) } returns topicoView

        topicoService.listar(null, pageable)

        verify(exactly = 1) { topicoRepository.findAll(pageable) }
        verify(exactly = 0) { topicoRepository.findByCursoNome(any(), any()) }
        verify(exactly = 1) { topicoViewMapper.map(any()) }

        assertThat(slot.captured.titulo).isEqualTo(topico.titulo)
        assertThat(slot.captured.mensagem).isEqualTo(topico.mensagem)
        assertThat(slot.captured.status).isEqualTo(topico.status)
    }

    @Test
    fun `deve lancar excecao se nao achar topico por id`() {
        every { topicoRepository.findById(any()) } returns Optional.empty()

        val actual = assertThrows<NotFoundException> {
            topicoService.buscarPorId(3)
        }

        assertThat(actual.message).isEqualTo(TopicoService.NOT_FOUND_MESSAGE)
    }
}