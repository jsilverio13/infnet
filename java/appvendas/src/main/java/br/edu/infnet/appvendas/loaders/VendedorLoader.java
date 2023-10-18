package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.model.domain.Vendedor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class VendedorLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoVendedor  = "vendedores.txt";
        try (FileReader arquivo = new FileReader(arquivoVendedor))
        {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();
            String[] campos = null;
            System.out.println();
            System.out.println("-------------- INICIO VENDEDOR LOADER --------------");
            while(linha != null){
                Vendedor vendedor = new Vendedor();

                campos = linha.split(";");

                vendedor.setNome(campos[0]);
                vendedor.setCpf(campos[1]);
                vendedor.setEmail(campos[2]);

                System.out.println(vendedor);

                linha = leitura.readLine();
            }

            System.out.println("-------------- FIM VENDEDOR LOADER --------------");
        }

    }
}
