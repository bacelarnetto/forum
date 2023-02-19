package br.com.bacel.forum.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class NovoTopicoForm (
    @field:NotBlank
    @field:Size(min = 3, max = 100)
    val titulo: String,

    @field:NotBlank
    @field:Size(min = 3, max = 300)
    val mensagem: String,

    @field:NotNull
    val idCurso: Long,

    @field:NotNull
    val idAutor: Long
)
