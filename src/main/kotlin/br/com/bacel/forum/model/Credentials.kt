package br.com.bacel.forum.model

import java.io.Serializable

data class Credentials(
    val username: String = "",
    val password: String = ""
): Serializable
