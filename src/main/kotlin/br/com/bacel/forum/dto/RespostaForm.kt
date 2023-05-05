package br.com.bacel.forum.dto

import java.io.Serializable
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class RespostaForm (
    @field:NotBlank
    @field:Size(min = 3, max = 300)
    val mensagem: String,
    @field:NotNull
    val idTopico: Long,
    @field: NotNull
    val idAutor: Long,
    val solucao: Boolean
): Serializable