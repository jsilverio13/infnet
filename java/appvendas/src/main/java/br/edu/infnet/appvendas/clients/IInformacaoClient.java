package br.edu.infnet.appvendas.clients;

import br.edu.infnet.appvendas.model.domain.Informacao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(url = "http://localhost:8098/api/informacao", name = "informacaoClient")
public interface IInformacaoClient {

    @GetMapping(value = "/lista")
    public List<Informacao> obterLista();

    @PostMapping(value = "/incluir")
    public Informacao incluir(Informacao informacao);

    @PostMapping(value = "/{id}/excluir")
    public void excluir(@PathVariable Integer id);
}