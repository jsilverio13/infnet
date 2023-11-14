package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProdutoController {

    private final AppController appController;
    private final ProdutoService produtoService;

    public ProdutoController(AppController appController, ProdutoService produtoService) {
        this.appController = appController;
        this.produtoService = produtoService;
    }

    @GetMapping(value = "/produto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        produtoService.excluir(id);

        return "redirect:/produto/lista";
    }

    @GetMapping(value = "/produto/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        Produto produto = produtoService.pesquisar(campoBusca);

        if (produto != null) {
            model.addAttribute("objeto", produto);
            return appController.showHome(model);
        }
        return "redirect:/produto/lista";
    }

    @GetMapping(value = "/produto/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "produto");
        model.addAttribute("listagem", produtoService.obterLista());
        model.addAttribute("titulo", "Produtos");

        return appController.showHome(model);
    }
}
