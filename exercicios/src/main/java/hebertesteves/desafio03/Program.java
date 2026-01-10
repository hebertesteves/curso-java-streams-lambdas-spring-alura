package hebertesteves.desafio03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        // Ex1
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        System.out.println();

        // Ex2
        List<String> palavras = Arrays.asList("java", "stream", "lambda");
        palavras.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println();

        // Ex3
        List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> novaListaNumeros = numeros1.stream()
                .filter(n -> n % 2 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        novaListaNumeros.forEach(System.out::println);

        System.out.println();

        // Ex4
        List<String> palavras1 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        palavras1.stream().distinct().forEach(System.out::println);

        System.out.println();

        // Ex5
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );

        List<Integer> numerosPrimos = listaDeNumeros.stream()
                .flatMap(n -> n.stream()
                        .filter(num -> {
                            if (num <= 1) return false;

                            for (int i = 2; i <= Math.sqrt(num); i++) {
                                if (num % i == 0) return false;
                            }

                            return true;
                        }))
                .sorted()
                .collect(Collectors.toList());

        numerosPrimos.forEach(System.out::println);

        System.out.println();

        // Ex6
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );

        pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .sorted(Comparator.comparing(Pessoa::getNome))
                .map(Pessoa::getNome)
                .forEach(System.out::println);

        System.out.println();

        // Ex7
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> novaListaDeProdutos = produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos") && p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toList());

        novaListaDeProdutos.forEach(System.out::println);

        System.out.println();

        // Ex8
        produtos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase("Eletrônicos"))
                .sorted(Comparator.comparing(Produto::getPreco))
                .limit(3)
                .forEach(System.out::println);
    }
}
