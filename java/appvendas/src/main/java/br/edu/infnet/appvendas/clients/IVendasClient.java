package br.edu.infnet.appvendas.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "http://localhost:8098/api/vendas", name = "vendasClient")
public interface IVendasClient {

    @GetMapping(value = "/informacoes")
    public List<String> obterInformacao();
}