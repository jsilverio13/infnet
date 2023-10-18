package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.model.domain.Movel;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;

@Component
public class MovelLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoMoveis  = "moveis.txt";
        try (FileReader arquivo = new FileReader(arquivoMoveis))
        {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();
            String[] campos = null;

            System.out.println();
            System.out.println("-------------- INICIO MOVEL LOADER --------------");
            while(linha != null){
                Movel movel = new Movel();

                campos = linha.split(";");

                movel.setDescricao(campos[0]);
                movel.setCodigo(Integer.parseInt(campos[1]));
                movel.setPreco(Float.parseFloat(campos[2]));
                movel.setEstoque(Boolean.parseBoolean(campos[3]));
                movel.setComodo(campos[4]);
                movel.setMaterial(campos[5]);

                System.out.println(movel);

                linha = leitura.readLine();
            }
            System.out.println("-------------- FIM MOVEL LOADER --------------");
        }

    }
}
