package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.service.MovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MovelController {
    private final AppController appController;
    private final MovelService movelService;

    public MovelController(AppController appController, MovelService movelService) {
        this.appController = appController;
        this.movelService = movelService;
    }

    @GetMapping(value = "/movel/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        movelService.excluir(id);

        return "redirect:/movel/lista";
    }

    @GetMapping(value = "/movel/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "movel");
        model.addAttribute("titulo", "Moveis");
        model.addAttribute("listagem", movelService.obterLista());

        return appController.showHome(model);
    }
}
