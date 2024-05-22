package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * Function<T, R>: Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R.
 * É utilizada para transformar ou mapear os elementos do Stream em outros valores ou tipos.
 */
public class FunctionExample {

    public static void main(String[] args) {
        // Cria uma lista de números
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6 ,7 , 8, 9 );

        // Cria um Function que triplica valores com lambda
        Function<Integer, Integer> triplicaNumeros = n -> n * 3;

        // Cria um Function que triplica valores sem lambda
        Function<Integer, Integer> triplicaNumeros2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return null;
            }
        };

        // Triplicar os números e colocar numa lista
        List<Integer> numerosTriplicados = numeros.stream()
                .map(triplicaNumeros)
                .collect(Collectors.toList());

        // Passando a direto a Lambda na lista
        List<Integer> numerosTriplicados2 = numeros.stream()
                .map((n) -> n * 3)
                .toList();// <--- fazendo direto o toList()

        // Imprimir os números triplicados
        numerosTriplicados.forEach(n -> System.out.println(n));

        System.out.println();

        // Imprimir os números triplicados com method reference
        numerosTriplicados2.forEach(System.out::println);
    }



}
