package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Movel;
import br.edu.infnet.appvendas.model.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProdutoService {

    public final Map<Integer, Produto> mapaProduto = new HashMap<Integer, Produto>();
    public void incluir(Produto produto){
        mapaProduto.put(produto.getCodigo(), produto);
    }
    public void excluir(Produto produto){
        mapaProduto.remove(produto.getCodigo());
    }
    public Collection<Produto> obterLista(){
        return  mapaProduto.values();
    }
}
