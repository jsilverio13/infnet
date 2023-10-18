package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.model.domain.Livro;
import br.edu.infnet.appvendas.model.domain.Movel;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

@Component
public class LivroLoader implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoLivros  = "livros.txt";
        try (FileReader arquivo = new FileReader(arquivoLivros))
        {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();
            String[] campos = null;
            System.out.println();
            System.out.println("-------------- INICIO LIVRO LOADER --------------");
            while(linha != null){
                Livro livro = new Livro();

                campos = linha.split(";");

                livro.setDescricao(campos[0]);
                livro.setCodigo(Integer.parseInt(campos[1]));
                livro.setPreco(Float.parseFloat(campos[2]));
                livro.setEstoque(Boolean.parseBoolean(campos[3]));
                livro.setAutor(campos[4]);


                livro.setData(LocalDate.parse(campos[5]));
                livro.setGenero(campos[6]);

                System.out.println(livro);

                linha = leitura.readLine();
            }

            System.out.println("-------------- FIM LIVRO LOADER --------------");
        }

    }
}
