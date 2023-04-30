package br.com.bacel.forum.service

import br.com.bacel.forum.dto.AtualizacaoTopicoForm
import br.com.bacel.forum.dto.NovoTopicoForm
import br.com.bacel.forum.dto.TopicoPorCategoriaDto
import br.com.bacel.forum.dto.TopicoView
import br.com.bacel.forum.exception.NotFoundException
import br.com.bacel.forum.mapper.TopicoFormMapper
import br.com.bacel.forum.mapper.TopicoViewMapper
import br.com.bacel.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.ZoneOffset


@Service
class TopicoService(
    private val topicoRepository: TopicoRepository,
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper,
) {

    companion object {
        const val NOT_FOUND_MESSAGE = "TOPICO NÃO ENCONTRADO"
    }

    fun listar(
        nomeCurso: String?,
        paginacao : Pageable
    ): Page<TopicoView> {
        val topicos = if ( nomeCurso == null ){
            topicoRepository.findAll(paginacao)
        } else {
            topicoRepository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map {
                t ->
            topicoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepository.findById(id)
            .orElseThrow{NotFoundException(NOT_FOUND_MESSAGE)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topicoRepository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicoRepository.findById(form.id)
            .orElseThrow{NotFoundException(NOT_FOUND_MESSAGE)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        topico.dataAlteracao = LocalDateTime.now(ZoneOffset.UTC)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }

    fun buscarRelatorio() : List<TopicoPorCategoriaDto>{
        return topicoRepository.getRelatorio()
    }
}
