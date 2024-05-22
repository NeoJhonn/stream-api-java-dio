package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


/*
* Consumer<T>: Representa uma operação que aceita um argumento do tipo T
* e não retorna nenhum resultado. É utilizada principalmente para realizar
* ações ou efeitos colaterais nos elementos do Stream sem modificar ou
* retornar um valor.
* */
public class ConsumerExample {

    public static void main(String[] args) {
        // Lista de números
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Usar um Consumer com expressão lambda para imprimir números ímpares
        Consumer<Integer> imprimirNumerosImparesLambda = numero -> {
          if (numero % 2 != 0) {
              System.out.print(numero + ", ");
          }
        };

        // Usar um Consumer com uma classe anônima para imprimir números ímpares
        Consumer<Integer> imprimirNumerosImparesClasseAnonima = new Consumer<Integer>() {
            @Override
            public void accept(Integer numero) {
                if (numero % 2 != 0) {
                    System.out.print(numero + ", ");
                }
            }
        };

        // usar o Consumer com classe anônima para imprimir números ímpares no Stream
        numeros.stream().forEach(imprimirNumerosImparesClasseAnonima);

        System.out.println();

        // usar o Consumer com lambda para imprimir números ímpares no Stream
        numeros.stream().forEach(imprimirNumerosImparesLambda);

        System.out.println();

        // Ou você pode passar direto o Consumer em formato de lambda
        numeros.stream().forEach(n -> {
            if (n % 2 != 0) {
                System.out.print(n + ", ");
            }
        });
    }
}
