package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *  Predicate<T>: Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro ou falso).
 *  É comumente usada para filtrar os elementos do Stream com base em alguma condição.
 */
public class PredicateExample {

    public static void main(String[] args) {
        // Criar uma lista de palavras
        List<String> palavras = Arrays.asList("Batata", "feijão", "ovo", "pão", "cenoura");

        // Criar um Predicate
        Predicate<String> parasDeCincoCaracters = new Predicate<String>() {
            @Override
            public boolean test(String palavra) {
                return palavra.length() > 5;
            }
        };

        // Criar um Predicate com lambda
        Predicate<String> parasDeCincoCaracters2 = palavra -> palavra.length() > 5;

        // Filtrar as palavars com mais de 5 caracteres e imprimir
        palavras.stream().filter(parasDeCincoCaracters2).forEach(p -> System.out.println(p));

        System.out.println();

        // Filtrar as palavars com mais de 5 caracteres e imprimir
        // passando direto a lambda do Predicate e usando method
        // reference no forEach para imprimir
        palavras.stream().filter(p -> p.length() < 5).forEach(System.out::println);
    }
}
