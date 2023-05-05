package br.com.bacel.forum.mapper


import br.com.bacel.forum.dto.RespostaForm
import br.com.bacel.forum.model.Resposta
import br.com.bacel.forum.repository.TopicoRepository
import br.com.bacel.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private var usuarioService: UsuarioService,
    private var topicoRepository: TopicoRepository
): Mapper<RespostaForm, Resposta>  {
    override fun map(t: RespostaForm): Resposta {
        return Resposta(
            mensagem = t.mensagem,
            solucao = t.solucao,
            autor = usuarioService.buscarPorId(t.idAutor),
            topico = topicoRepository.findById(t.idTopico).get()
        )
    }
}