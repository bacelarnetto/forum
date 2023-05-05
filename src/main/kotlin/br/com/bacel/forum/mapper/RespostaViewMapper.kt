package br.com.bacel.forum.mapper

import br.com.bacel.forum.dto.RespostaView
import br.com.bacel.forum.dto.TopicoView
import br.com.bacel.forum.model.Resposta
import br.com.bacel.forum.model.Topico
import org.springframework.stereotype.Component

@Component
class RespostaViewMapper: Mapper<Resposta, RespostaView>  {

    override fun map(t: Resposta): RespostaView {
        return RespostaView(
            id = t.id,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            solucao = t.solucao,
            tituloTopico = t.topico.titulo,
            autor = t.autor.nome
        )
    }

}