package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Livro;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class LivroService {
    public final Map<Integer, Livro> mapaLivro = new HashMap<Integer, Livro>();
    public void incluir(Livro livro){
        mapaLivro.put(livro.getCodigo(), livro);
    }
    public void excluir(Livro livro){
        mapaLivro.remove(livro.getCodigo());
    }

    public Collection<Livro> obterLista(){
        return  mapaLivro.values();
    }
}
