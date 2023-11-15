package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.clients.IInformacaoClient;
import br.edu.infnet.appvendas.model.domain.Informacao;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InformacaoService {

    private final IInformacaoClient informacaoClient;

    public InformacaoService(IInformacaoClient informacaoClient) {
        this.informacaoClient = informacaoClient;
    }

    public List<Informacao> obterLista() {
        return informacaoClient.obterLista();
    }

    public Informacao incluir(Informacao informacao){
        return informacaoClient.incluir(informacao);
    }

    public void excluir(Integer id){
        informacaoClient.excluir(id);
    }
}