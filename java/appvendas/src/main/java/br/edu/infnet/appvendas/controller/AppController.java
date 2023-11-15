package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    private final ProdutoService produtoService;
    private final VendedorService vendedorService;
    private final LivroService livroService;
    private final MovelService movelService;
    private final InformacaoService informacaoService;

    public AppController(ProdutoService produtoService, VendedorService vendedorService, LivroService livroService, MovelService movelService, InformacaoService informacaoService) {
        this.produtoService = produtoService;
        this.vendedorService = vendedorService;
        this.livroService = livroService;
        this.movelService = movelService;
        this.informacaoService = informacaoService;
    }

    @GetMapping(value = "/")
    public String showHome(Model model) {
        model.addAttribute("informacoes", informacaoService.obterLista());
        model.addAttribute("qtdVendedores", vendedorService.obterQuantidade());
        model.addAttribute("qtdProdutos", produtoService.obterQuantidade());
        model.addAttribute("qtdLivros", livroService.obterQuantidade());
        model.addAttribute("qtdMoveis", movelService.obterQuantidade());
        return "home";
    }
}

