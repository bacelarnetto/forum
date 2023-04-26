package br.com.bacel.forum.util
import java.util.*

fun main() {
    val username = "admin@admin.com"
    val password = "admin"

    // Concatena o nome de usuário e senha separados por dois pontos
    val credentials = "$username:$password"

    // Codifica a string em base64
    val encodedCredentials = Base64.getEncoder().encodeToString(credentials.toByteArray())

    println(encodedCredentials)
}

