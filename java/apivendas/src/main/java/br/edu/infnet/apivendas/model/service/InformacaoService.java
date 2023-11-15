package br.edu.infnet.apivendas.model.service;

import br.edu.infnet.apivendas.model.domain.Informacao;
import br.edu.infnet.apivendas.model.repository.IInformacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InformacaoService {

    public InformacaoService(IInformacaoRepository informacaoRepository) {
        this.informacaoRepository = informacaoRepository;
    }

    IInformacaoRepository informacaoRepository;
    public List<Informacao> obterLista() {
        return (List<Informacao>) informacaoRepository.findAll();
    }

    public Informacao incluir(Informacao informacao){
        return informacaoRepository.save(informacao);
    }

    public void excluir(Integer informacaoId){
        informacaoRepository.deleteById(informacaoId);
    }
}