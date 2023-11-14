package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.clients.IVendasClient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VendasService {

    private final IVendasClient vendasClient;

    public VendasService(IVendasClient vendasClient) {
        this.vendasClient = vendasClient;
    }

    public List<String> obterInformacao() {
        return vendasClient.obterInformacao();
    }
}