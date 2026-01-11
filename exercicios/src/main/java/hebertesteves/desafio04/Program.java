package hebertesteves.desafio04;

import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        // Ex1
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        Optional<Integer> max = numeros.stream()
                        .max(Integer::compare);

        max.ifPresent(System.out::println);

        System.out.println();

        // Ex2
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> map = palavras.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
        System.out.println(map);

        System.out.println();

        // Ex3
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        String resultado = nomes.stream()
                        .collect(Collectors.joining(", "));

        System.out.println(resultado);

        System.out.println();

        // Ex4
        List<Integer> numeros1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        int soma = numeros1.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n * n)
                        .sum();

        System.out.println(soma);

        System.out.println();

        // Ex5
        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> particionado = numeros2.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));

        System.out.println("Pares: " + particionado.get(true));
        System.out.println("Impares: " + particionado.get(false));

        System.out.println();

        // Ex6
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );

        List<Produto> novaLista = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() < 1000)
                .sorted(Comparator.comparing(Produto::getPreco))
                .collect(Collectors.toList());

        System.out.println(novaLista);

        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.toList()));

        System.out.println(produtosPorCategoria);

        System.out.println();

        // Ex7
        Map<String, Long> quantidadeDeProdutosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));

        System.out.println(quantidadeDeProdutosPorCategoria);

        System.out.println();

        // Ex8
        Map<String, Optional<Produto>> produtoMaisCaroPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));

        System.out.println(produtoMaisCaroPorCategoria);

        System.out.println();

        // Ex9
        Map<String, Double> precoTotalPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));

        System.out.println(precoTotalPorCategoria);
    }
}
