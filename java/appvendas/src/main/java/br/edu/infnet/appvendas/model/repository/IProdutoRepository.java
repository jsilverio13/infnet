package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer> {
    @Query("from Produto p where p.vendedor.id =:vendedorId")
    Collection<Produto> obterLista(Integer vendedorId);

    Produto findByDescricaoContaining(String descricao);


}
