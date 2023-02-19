package br.com.bacel.forum.service

import br.com.bacel.forum.dto.NovoTopicoForm
import br.com.bacel.forum.dto.TopicoView
import br.com.bacel.forum.dto.AtualizacaoTopicoForm
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
    private var topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                t -> topicoViewMapper.map(t)
        }.collect(Collectors.toList());
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter({t -> t.id == id}).findFirst().get();
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) : TopicoView{
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1L
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm) {
        val topico = topicos.stream().filter({t -> t.id == form.id}).findFirst().get();
        topicos = topicos.minus(topico).plus(Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            resposta = topico.resposta,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        ))
    }

    fun deletar(id: Long) {
        val topico = topicos.stream().filter({t -> t.id == id}).findFirst().get();
        topicos = topicos.minus(topico)
    }


}