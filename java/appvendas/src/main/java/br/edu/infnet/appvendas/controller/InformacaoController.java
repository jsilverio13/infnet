package br.edu.infnet.appvendas.controller;

import br.edu.infnet.appvendas.model.domain.Informacao;
import br.edu.infnet.appvendas.model.service.InformacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "informacao")
public class InformacaoController {
     private final InformacaoService informacaoService;

    public InformacaoController(InformacaoService informacaoService) {
        this.informacaoService = informacaoService;
    }
    @PostMapping(value = "/incluir")
    public String incluir(Informacao informacao) {
        System.out.println("INFORMACAO: " + informacao);
        Informacao result = informacaoService.incluir(informacao);
        System.out.println("RESULT: " + result);
        return "redirect:/";
    }

    @GetMapping(value = "/lista")
    public List<Informacao> obterLista(){
        return  informacaoService.obterLista();
    }

    @GetMapping(value = "/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        informacaoService.excluir(id);
        return "redirect:/";
    }
}
