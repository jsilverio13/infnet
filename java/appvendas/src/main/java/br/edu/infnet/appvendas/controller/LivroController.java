package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Livro;
import br.edu.infnet.appvendas.model.service.LivroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class LivroController {
    private final AppController appController;
    private final LivroService livroService;


    public LivroController(LivroService livroService, AppController appController) {
        this.appController = appController;
        this.livroService = livroService;
    }

    @GetMapping(value = "/livro/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        livroService.excluir(id);
        return "redirect:/livro/lista";
    }

    @GetMapping(value = "/livro/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        Livro livro = livroService.pesquisar(campoBusca);

        if (livro != null) {
            model.addAttribute("objeto", livro);
            return appController.showHome(model);
        }
        return "redirect:/livro/lista";
    }

    @GetMapping(value = "/livro/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "livro");
        model.addAttribute("titulo", "Livros");
        model.addAttribute("listagem", livroService.obterLista());

        return appController.showHome(model);
    }

}
