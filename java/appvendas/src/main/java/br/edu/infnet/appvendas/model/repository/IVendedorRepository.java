package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendedorRepository extends CrudRepository<Vendedor, Integer> {
}
