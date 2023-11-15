package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Movel;
import br.edu.infnet.appvendas.model.service.MovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "movel")
public class MovelController {
    private final AppController appController;
    private final MovelService movelService;

    public MovelController(AppController appController, MovelService movelService) {
        this.appController = appController;
        this.movelService = movelService;
    }

    @GetMapping(value = "/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        movelService.excluir(id);

        return "redirect:/movel/lista";
    }

    @GetMapping(value = "/pesquisar")
    public String pesquisar(Model model, String campoBusca) {

        Movel movel = movelService.pesquisar(campoBusca);

        if (movel != null) {
            model.addAttribute("objeto", movel);
            return appController.showHome(model);
        }
        return "redirect:/movel/lista";
    }


    @GetMapping(value = "/lista")
    public String obterLista(Model model) {
        model.addAttribute("rota", "movel");
        model.addAttribute("titulo", "Moveis");
        model.addAttribute("listagem", movelService.obterLista());

        return appController.showHome(model);
    }
}
