package br.com.bacel.forum.controller

import br.com.bacel.forum.dto.RespostaForm
import br.com.bacel.forum.dto.RespostaView
import br.com.bacel.forum.service.RespostaService
import io.swagger.v3.oas.annotations.security.SecurityRequirement
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearerAuth")
class RespostaController (
    private val respostaService: RespostaService
){
    @PostMapping
    fun salvar(
        @RequestBody @Valid resposta: RespostaForm,
        uriBuilder: UriComponentsBuilder
    ) : ResponseEntity<RespostaView> {
        val respostaView = respostaService.cadastrar(resposta)
        val uri = uriBuilder.path("/respostas/${respostaView.id}").build().toUri()
        return ResponseEntity.created(uri).body(respostaView)
    }
}



