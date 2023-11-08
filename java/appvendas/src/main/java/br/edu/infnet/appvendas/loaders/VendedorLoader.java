package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.FileLogger;
import br.edu.infnet.appvendas.model.domain.Endereco;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.VendedorService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

@Order(1)
@Component
public class VendedorLoader implements ApplicationRunner {

    private final VendedorService vendedorService;

    public VendedorLoader(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoVendedor = "files/vendedores.txt";
        try (FileReader arquivo = new FileReader(arquivoVendedor)) {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();
            System.out.println();
            System.out.println("-------------- INICIO VENDEDOR LOADER --------------");

            while (linha != null) {
                Vendedor vendedor = new Vendedor();

                String[] campos = linha.split(";");

                vendedor.setNome(campos[0]);
                vendedor.setCpf(campos[1]);
                vendedor.setEmail(campos[2]);

                vendedor.setEndereco(new Endereco(campos[3]));

                try {
                    vendedorService.incluir(vendedor);
                } catch (ConstraintViolationException e) {
                    FileLogger.logException("Erro ao inserir [VENDEDOR]: " + vendedor + "\nMensagem: " + e.getMessage());
                }


                linha = leitura.readLine();
            }

            Collection<Vendedor> vendedores = vendedorService.obterLista();
            for (Vendedor vendedor : vendedores) {
                System.out.println(vendedor);
            }

            System.out.println("-------------- FIM VENDEDOR LOADER --------------");
        }

    }
}
