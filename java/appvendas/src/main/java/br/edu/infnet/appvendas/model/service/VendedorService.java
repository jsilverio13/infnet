package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.IVendedorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendedorService {

    private final IVendedorRepository vendedorRepository;

    public VendedorService(IVendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    public void incluir(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }

    public void excluir(Integer vendedorId) {
        vendedorRepository.deleteById(vendedorId);
    }

    public Collection<Vendedor> obterLista() {
        return (Collection<Vendedor>) vendedorRepository.findAll();
    }
}
