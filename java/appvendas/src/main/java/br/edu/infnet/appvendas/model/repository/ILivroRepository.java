package br.edu.infnet.appvendas.model.repository;

import br.edu.infnet.appvendas.model.domain.Livro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILivroRepository extends CrudRepository<Livro, Integer> {
    Livro findByAutorContaining(String autor);
}
