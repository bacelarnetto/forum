package br.com.bacel.forum.model

object TopicoTest {
    fun build() = Topico(
        id = 1,
        titulo = "Kotlin Basico",
        mensagem = "Aprendendo kotlin basico",
        curso = CursoTest.build(),
        autor = UsuarioTest.build(),
        status = StatusTopico.NAO_RESPONDIDO
    )
}