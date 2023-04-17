package br.com.bacel.forum.service

import br.com.bacel.forum.dto.AtualizacaoTopicoForm
import br.com.bacel.forum.dto.NovoTopicoForm
import br.com.bacel.forum.dto.TopicoView
import br.com.bacel.forum.exception.NotFoundException
import br.com.bacel.forum.mapper.TopicoFormMapper
import br.com.bacel.forum.mapper.TopicoViewMapper
import br.com.bacel.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private var topicoViewMapper: TopicoViewMapper,
    private var topicoFormMapper: TopicoFormMapper,
) {

    companion object {
        const val NOT_FOUND_MESSAGE = "TOPICO NÃO ENCONTRADO"
    }

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream()
            .filter({ t -> t.id == id })
            .findFirst().orElseThrow{NotFoundException(NOT_FOUND_MESSAGE)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1L
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream()
            .filter({ t -> t.id == form.id })
            .findFirst().orElseThrow{NotFoundException(NOT_FOUND_MESSAGE)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            resposta = topico.resposta,
            status = topico.status,
            dataCriacao = topico.dataCriacao,
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream()
            .filter({ t -> t.id == id })
            .findFirst().orElseThrow{NotFoundException(NOT_FOUND_MESSAGE)}
        topicos = topicos.minus(topico)
    }
}
