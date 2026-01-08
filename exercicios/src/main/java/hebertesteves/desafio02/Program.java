package hebertesteves.desafio02;

import java.util.Arrays;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        // Ex 1
        Multiplicacao multiplicacao = (a, b) -> a * b;
        System.out.println(multiplicacao.multiplicar(5, 3));

        // Ex2
        Primo primo = n -> {
            if (n <= 1) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }

            return true;
        };

        System.out.println(primo.verificarPrimo(5));
        System.out.println(primo.verificarPrimo(10));

        // Ex3
        ConversorString conversorString = String::toUpperCase;
        System.out.println(conversorString.converterParaLetraMaiusculas("hello world"));

        // Ex4
        Palindromo palindromo = str -> str.equals(new StringBuilder(str).reverse().toString());

        System.out.println(palindromo.verificarPalindromo("hebert"));

        // Ex5
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numerosMultiplicadosPor3 = numeros.stream().map(n -> n * 3).toList();
        System.out.println(numerosMultiplicadosPor3);

        // Ex6
        List<String> nomes = Arrays.asList("Zenon", "Barry", "Gary", "Harvey", "Mike", "Albedo");
        nomes.sort(String::compareTo);
        System.out.println(nomes);

        // Ex7
        Divisor divisor = (a, b) -> {
          if (b == 0) throw new ArithmeticException("Divisão por zero");

          return a / b;
        };

        try {
            System.out.println(divisor.dividir(4.0, 2.0));
            System.out.println(divisor.dividir(4.0, 0.0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

    }
}
