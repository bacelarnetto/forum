package br.com.bacel.forum.model
object UsuarioTest {
    fun build() = Usuario(id = 1, nome = "Joao", email = "jvc.martins", password = "123")
    fun buildToToken() = Usuario(nome = "admin", email = "admin@admin.com", password = "123456")
}