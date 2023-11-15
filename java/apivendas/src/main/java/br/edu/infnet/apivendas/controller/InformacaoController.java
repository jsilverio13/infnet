package br.edu.infnet.apivendas.controller;

import br.edu.infnet.apivendas.model.domain.Informacao;
import br.edu.infnet.apivendas.model.service.InformacaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/informacao")
public class InformacaoController {
    private final InformacaoService informacaoService;

    public InformacaoController(InformacaoService informacaoService) {
        this.informacaoService = informacaoService;
    }

    @GetMapping(value = "/lista")
    public List<Informacao> obterLista() {
        return informacaoService.obterLista();
    }

    @PostMapping(value = "/incluir")
    public Informacao incluir(@RequestBody Informacao informacao) {
        return informacaoService.incluir(informacao);
    }

    @PostMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        informacaoService.excluir(id);
    }

}