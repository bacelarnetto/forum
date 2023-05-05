package br.com.bacel.forum.controller

import br.com.bacel.forum.service.TopicoService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.ui.Model

@Controller
@RequestMapping("/relatorios")
class RelatorioController(private val topicoService: TopicoService) {

    @GetMapping
    fun relatorio(model: Model): String {
        model.addAttribute("topicosPorCategorias", topicoService.buscarRelatorio())
        return "relatorio"
    }
}