package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Movel;
import br.edu.infnet.appvendas.model.repository.IMovelRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovelService {
    private final IMovelRepository movelRepository;

    public MovelService(IMovelRepository movelRepository) {
        this.movelRepository = movelRepository;
    }

    public void incluir(Movel movel) {
        movelRepository.save(movel);
    }

    public void excluir(Integer movelId) {
        movelRepository.deleteById(movelId);
    }

    public Collection<Movel> obterLista() {
        return (Collection<Movel>) movelRepository.findAll();
    }

    public long obterQuantidade() {
        return movelRepository.count();
    }

    public Movel pesquisar(String descricao) {
        return movelRepository.findByDescricaoContaining(descricao);
    }
}
