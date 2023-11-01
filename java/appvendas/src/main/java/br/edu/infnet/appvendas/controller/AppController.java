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

    @GetMapping(value = "/vendedor/lista")
    public String obterVendedores(Model model) {
        model.addAttribute("listagem", vendedorService.obterLista());
        model.addAttribute("titulo", "Vendedores");

        return showHome(model);
    }

    @GetMapping(value = "/produto/lista")
    public String obterProdutos(Model model) {
        model.addAttribute("titulo", "Produtos");
        model.addAttribute("listagem", produtoService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/livro/lista")
    public String obterLivros(Model model) {
        model.addAttribute("titulo", "Livros");
        model.addAttribute("listagem", livroService.obterLista());

        return showHome(model);
    }

    @GetMapping(value = "/movel/lista")
    public String obterMoveis(Model model) {
        model.addAttribute("titulo", "Moveis");
        model.addAttribute("listagem", movelService.obterLista());

        return showHome(model);
    }
}

