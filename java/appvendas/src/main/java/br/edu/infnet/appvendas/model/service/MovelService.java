package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Movel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class MovelService {
    public final Map<Integer, Movel> mapamovel = new HashMap<Integer, Movel>();
    public void incluir(Movel movel){
        mapamovel.put(movel.getCodigo(), movel);
    }
    public void excluir(Movel movel){
        mapamovel.remove(movel.getCodigo());
    }
    public Collection<Movel> obterLista(){
        return  mapamovel.values();
    }
}
