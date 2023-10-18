package br.edu.infnet.appvendas;

import br.edu.infnet.appvendas.loaders.LivroLoader;
import br.edu.infnet.appvendas.loaders.MovelLoader;
import br.edu.infnet.appvendas.loaders.VendedorLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppVendasApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppVendasApplication.class, args);

		
	}

}

