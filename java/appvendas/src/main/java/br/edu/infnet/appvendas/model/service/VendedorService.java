package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendedorService {
    private final Map<String, Vendedor> mapaVendedor = new HashMap<String, Vendedor>();
    public void incluir(Vendedor vendedor){
        mapaVendedor.put(vendedor.getCpf(), vendedor);
    }
    public void excluir(Vendedor vendedor){
        mapaVendedor.remove(vendedor.getCpf());
    }

    public Collection<Vendedor> obterLista(){
        return  mapaVendedor.values();
    }

}
