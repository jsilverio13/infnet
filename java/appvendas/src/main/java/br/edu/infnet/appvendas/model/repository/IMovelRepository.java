package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Movel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovelRepository extends CrudRepository<Movel, Integer> {
}
