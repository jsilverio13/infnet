package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.service.LivroService;
import br.edu.infnet.appvendas.model.service.MovelService;
import br.edu.infnet.appvendas.model.service.ProdutoService;
import br.edu.infnet.appvendas.model.service.VendedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    private final ProdutoService produtoService;
    private final VendedorService vendedorService;
    private final LivroService livroService;
    private final MovelService movelService;

    public AppController(ProdutoService produtoService, VendedorService vendedorService, LivroService livroService, MovelService movelService) {
        this.produtoService = produtoService;
        this.vendedorService = vendedorService;
        this.livroService = livroService;
        this.movelService = movelService;
    }

    @GetMapping(value = "/")
    public String showHome(Model model) {

        model.addAttribute("qtdVendedores", vendedorService.obterQuantidade());
        model.addAttribute("qtdProdutos", produtoService.obterQuantidade());
        model.addAttribute("qtdMoveis", livroService.obterQuantidade());
        model.addAttribute("qtdLivros", movelService.obterQuantidade());
        return "home";
    }
}

