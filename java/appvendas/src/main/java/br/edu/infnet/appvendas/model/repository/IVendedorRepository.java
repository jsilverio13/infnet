package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVendedorRepository extends CrudRepository<Vendedor, Integer> {
    Vendedor findByCpfStartsWith(String cpf);

    List<Vendedor> findAll(Sort sort);
}
