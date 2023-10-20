package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.model.domain.Livro;
import br.edu.infnet.appvendas.model.service.LivroService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Collection;

@Order(3)
@Component
public class LivroLoader implements ApplicationRunner {

    final LivroService livroService;

    public LivroLoader(LivroService livroService) {
        this.livroService = livroService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoLivros  = "files/livros.txt";

        try (FileReader arquivo = new FileReader(arquivoLivros))
        {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();

            System.out.println();
            System.out.println("-------------- INICIO LIVRO LOADER --------------");

            while(linha != null){
                Livro livro = new Livro();

                String[] campos = linha.split(";");

                livro.setTipoProduto(campos[0]);
                livro.setDescricao(campos[1]);
                livro.setCodigo(Integer.parseInt(campos[2]));
                livro.setPreco(Float.parseFloat(campos[3]));
                livro.setEstoque(Boolean.parseBoolean(campos[4]));
                livro.setAutor(campos[5]);
                livro.setData(LocalDate.parse(campos[6]));
                livro.setGenero(campos[7]);

                livroService.incluir(livro);

                linha = leitura.readLine();
            }

            Collection<Livro> livros = livroService.obterLista();
            for (Livro livro: livros) {
                System.out.println(livro);
            }

            System.out.println("-------------- FIM LIVRO LOADER --------------");
        }

    }
}
