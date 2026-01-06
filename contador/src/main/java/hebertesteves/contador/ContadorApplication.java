package hebertesteves.contador;

import com.fasterxml.jackson.databind.ObjectMapper;
import hebertesteves.contador.model.Avaliacao;
import hebertesteves.contador.model.Servico;
import hebertesteves.contador.model.Tarefa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ContadorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContadorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao contador!");
		System.out.println("----------------------");

		System.out.print("Digite um numero: ");
		int numero = sc.nextInt();

		for (int i = 1; i <= numero; i++) {
			System.out.print(i + " ");
		}

		System.out.println();

		Tarefa tarefa = new Tarefa("Desafio 1", true, "Hebert");
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.writeValue(new File("tarefa.json"), tarefa);

		Tarefa tarefa1 = objectMapper.readValue(new File("tarefa.json"), Tarefa.class);
		System.out.println(tarefa1);

		Avaliacao<Servico> servicoAvaliacao = new Avaliacao<>();
		servicoAvaliacao.setItem(new Servico());
		servicoAvaliacao.setNota(10.0);
		servicoAvaliacao.setComentario("Oiii");
		List<Avaliacao<Servico>> list = Arrays.asList(new Avaliacao<Servico>(new Servico(), 10.0, "Servico 1"), new Avaliacao<Servico>(new Servico(), 9.5, "Servico 2"));
		double media = servicoAvaliacao.calcularMediaNotas(list);
		System.out.println(media);
		sc.close();
	}
}
