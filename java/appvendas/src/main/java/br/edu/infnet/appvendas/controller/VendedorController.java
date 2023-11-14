package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.VendedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VendedorController {

    private final AppController appController;
    private final VendedorService vendedorService;

    public VendedorController(AppController appController, VendedorService vendedorService) {
        this.appController = appController;
        this.vendedorService = vendedorService;
    }

    @GetMapping(value = "/vendedor/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        vendedorService.excluir(id);

        return "redirect:/vendedor/lista";
    }

    @GetMapping(value = "/vendedor/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        Vendedor vendedor = vendedorService.pesquisar(campoBusca);

        if (vendedor != null) {
            model.addAttribute("objeto", vendedor);
            return appController.showHome(model);
        }
        return "redirect:/vendedor/lista";
    }

    @GetMapping(value = "/vendedor/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "vendedor");
        model.addAttribute("listagem", vendedorService.obterLista());
        model.addAttribute("titulo", "Vendedores");

        return appController.showHome(model);
    }
}
