package br.com.bacel.forum.service

import br.com.bacel.forum.dto.RespostaForm
import br.com.bacel.forum.dto.RespostaView
import br.com.bacel.forum.mapper.RespostaFormMapper
import br.com.bacel.forum.mapper.RespostaViewMapper
import br.com.bacel.forum.repository.RespostaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RespostaService (
    private val respostaRepository: RespostaRepository,
    private var respostaFormMapper: RespostaFormMapper,
    private var respostaViewMapper: RespostaViewMapper,
    private val emailService: EmailService
){

    @Transactional
    fun cadastrar(form: RespostaForm) : RespostaView {
        val resposta = respostaFormMapper.map(form)
        respostaRepository.save(resposta)
        emailService.notificar(
            resposta.topico.autor.email,
        )
        return respostaViewMapper.map(resposta)
    }

}