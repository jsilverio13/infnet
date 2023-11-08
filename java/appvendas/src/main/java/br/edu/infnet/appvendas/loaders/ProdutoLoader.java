package br.edu.infnet.appvendas.loaders;

import br.edu.infnet.appvendas.FileLogger;
import br.edu.infnet.appvendas.model.Constants;
import br.edu.infnet.appvendas.model.domain.Livro;
import br.edu.infnet.appvendas.model.domain.Movel;
import br.edu.infnet.appvendas.model.domain.Produto;
import br.edu.infnet.appvendas.model.domain.Vendedor;
import br.edu.infnet.appvendas.model.service.ProdutoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.Collection;

@Order(2)
@Component
public class ProdutoLoader implements ApplicationRunner {

    private final ProdutoService produtoService;

    public ProdutoLoader(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        final String arquivoProdutos = "files/produtos.txt";
        try (FileReader arquivo = new FileReader(arquivoProdutos)) {
            BufferedReader leitura = new BufferedReader(arquivo);
            String linha = leitura.readLine();
            System.out.println();
            System.out.println("-------------- INICIO PRODUTO LOADER --------------");

            while (linha != null) {
                String[] campos = linha.split(";");

                String tipoProduto = campos[0];
                Vendedor vendedor = new Vendedor();

                switch (tipoProduto) {
                    case Constants.TipoProduto.Movel:
                        Movel movel = new Movel();

                        movel.setTipoProduto(campos[0]);
                        movel.setDescricao(campos[1]);
                        movel.setCodigo(Integer.parseInt(campos[2]));
                        movel.setPreco(Float.parseFloat(campos[3]));
                        movel.setEstoque(Boolean.parseBoolean(campos[4]));
                        movel.setComodo(campos[5]);
                        movel.setMaterial(campos[6]);

                        vendedor.setId(Integer.parseInt(campos[7]));
                        movel.setVendedor(vendedor);

                        movel.setGarantia(Integer.parseInt(campos[8]));
                        try {
                            produtoService.incluir(movel);
                        } catch (ConstraintViolationException e) {
                            FileLogger.logException("Erro ao inserir [MOVEL]: " + movel + "\nMensagem: " + e.getMessage());
                        }
                        break;
                    case Constants.TipoProduto.Livro:
                        Livro livro = new Livro();

                        livro.setTipoProduto(campos[0]);
                        livro.setDescricao(campos[1]);
                        livro.setCodigo(Integer.parseInt(campos[2]));
                        livro.setPreco(Float.parseFloat(campos[3]));
                        livro.setEstoque(Boolean.parseBoolean(campos[4]));
                        livro.setAutor(campos[5]);
                        livro.setData(LocalDate.parse(campos[6]));
                        livro.setGenero(campos[7]);

                        vendedor.setId(Integer.parseInt(campos[8]));
                        livro.setVendedor(vendedor);

                        try {
                            produtoService.incluir(livro);
                        } catch (ConstraintViolationException e) {
                            FileLogger.logException("Erro ao inserir [LIVRO]: " + livro + "\nMensagem: " + e.getMessage());
                        }

                        break;
                    default:
                        break;
                }

                linha = leitura.readLine();
            }

            Collection<Produto> produtos = produtoService.obterLista();
            for (Produto produto : produtos) {
                System.out.println(produto);
            }

            System.out.println("-------------- FIM PRODUTO LOADER --------------");
        }


        Vendedor vendedor = new Vendedor();
        vendedor.setId(1);
        Collection<Produto> produtos = produtoService.obterLista(vendedor);

        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

    }
}
