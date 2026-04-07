package Marcone.Gestao;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.*;

@SpringBootApplication
public class GestaoBateriasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoBateriasApplication.class, args);
	}

	@Bean
	CommandLineRunner init(OrdemRepository repo) {
		return args -> {
			if (repo.count() == 0) {
				repo.save(OrdemDeServico.builder()
						.placaVeiculo("ABC-1234")
						.nomeCliente("João Silva")
						.descricao("Troca de bateria + óleo")
						.mecanicoResponsavel("Mecânico 1")
						.status(StatusOrdem.A_FAZER)
						.prazo(LocalDate.now().plusDays(2))
						.build());

				repo.save(OrdemDeServico.builder()
						.placaVeiculo("XYZ-9876")
						.nomeCliente("Maria Oliveira")
						.descricao("Instalação de bateria")
						.mecanicoResponsavel("Mecânico 2")
						.status(StatusOrdem.EM_ANDAMENTO)
						.prazo(LocalDate.now().plusDays(1))
						.build());
			}
		};
	}
}