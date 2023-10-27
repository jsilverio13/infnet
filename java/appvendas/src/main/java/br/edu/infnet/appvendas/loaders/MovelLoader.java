package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.model.domain.Movel;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.MovelService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;

@Order(4)
@Component
public class MovelLoader implements ApplicationRunner {
    private final MovelService movelService;

    public MovelLoader(MovelService movelService) {
        this.movelService = movelService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoMoveis = "files/moveis.txt";

        try (FileReader arquivo = new FileReader(arquivoMoveis)) {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();

            System.out.println();
            System.out.println("-------------- INICIO MOVEL LOADER --------------");
            while (linha != null) {
                Movel movel = new Movel();

                String[] campos = linha.split(";");

                movel.setTipoProduto(campos[0]);
                movel.setDescricao(campos[1]);
                movel.setCodigo(Integer.parseInt(campos[2]));
                movel.setPreco(Float.parseFloat(campos[3]));
                movel.setEstoque(Boolean.parseBoolean(campos[4]));
                movel.setComodo(campos[5]);
                movel.setMaterial(campos[6]);

                Vendedor vendedor = new Vendedor();
                vendedor.setId(Integer.parseInt(campos[7]));

                movel.setVendedor(vendedor);

                movelService.incluir(movel);

                linha = leitura.readLine();
            }

            Collection<Movel> moveis = movelService.obterLista();
            for (Movel movel : moveis) {
                System.out.println(movel);
            }

            System.out.println("-------------- FIM MOVEL LOADER --------------");
        }

    }
}
