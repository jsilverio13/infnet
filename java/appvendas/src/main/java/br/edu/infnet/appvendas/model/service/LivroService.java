package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Livro;
import br.edu.infnet.appvendas.model.repository.ILivroRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LivroService {
    private final ILivroRepository livroRepository;

    public LivroService(ILivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void incluir(Livro livro) {
        livroRepository.save(livro);
    }

    public void excluir(Integer livroId) {
        livroRepository.deleteById(livroId);
    }

    public Collection<Livro> obterLista() {
        return (Collection<Livro>) livroRepository.findAll();
    }

    public long obterQuantidade() {
        return livroRepository.count();
    }

    public Livro pesquisar(String autor) {
        return livroRepository.findByAutor(autor);
    }
}
