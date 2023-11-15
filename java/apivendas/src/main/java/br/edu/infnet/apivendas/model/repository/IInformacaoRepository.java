package br.edu.infnet.apivendas.model.repository;

import br.edu.infnet.apivendas.model.domain.Informacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInformacaoRepository extends CrudRepository<Informacao, Integer> {
}
