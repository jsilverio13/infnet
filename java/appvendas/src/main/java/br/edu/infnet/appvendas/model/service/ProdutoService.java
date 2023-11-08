package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {
    IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void incluir(Produto produto) {
        produtoRepository.save(produto);
    }

    public void excluir(Integer produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    public Collection<Produto> obterLista() {
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Collection<Produto> obterLista(Vendedor vendedor) {
        return (Collection<Produto>) produtoRepository.obterLista(vendedor.getId());
    }

    public Collection<Produto> obterLista(Integer vendedorId) {
        return (Collection<Produto>) produtoRepository.obterLista(vendedorId);
    }

    public long obterQuantidade() {
        return produtoRepository.count();
    }
}
