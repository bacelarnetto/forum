package br.com.bacel.forum.dto

import java.io.Serializable

data class TopicoPorCategoriaDto(
    val categoria: String,
    val quantidade: Long
): Serializable