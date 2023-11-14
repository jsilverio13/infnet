package br.edu.infnet.appvendas.model.service;

import br.edu.infnet.appvendas.clients.IEnderecoClient;
import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.repository.IVendedorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendedorService {

    private final IVendedorRepository vendedorRepository;
    private final IEnderecoClient enderecoClient;

    public VendedorService(IVendedorRepository vendedorRepository, IEnderecoClient enderecoClient) {
        this.vendedorRepository = vendedorRepository;
        this.enderecoClient = enderecoClient;
    }

    public void incluir(Vendedor vendedor) {

        Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
        vendedor.setEndereco(endereco);

        vendedorRepository.save(vendedor);
    }

    public void excluir(Integer vendedorId) {
        vendedorRepository.deleteById(vendedorId);
    }


    public Vendedor pesquisar(String cpf) {
        return vendedorRepository.findByCpf(cpf);
    }

    public Collection<Vendedor> obterLista() {
        return (Collection<Vendedor>) vendedorRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
    }

    public long obterQuantidade() {
        return vendedorRepository.count();
    }
}
