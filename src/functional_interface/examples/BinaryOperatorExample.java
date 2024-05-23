package functional_interface.examples;


import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * BinaryOperator<T>: Representa uma operação que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T.
 * É usada para realizar operações de redução em pares de elementos, como somar números ou combinar objetos.
 */
public class BinaryOperatorExample {

    public static void main(String[] args) {
        // Lista de números inteiros
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        // Crira um BinaryOperator que soma dois números
        BinaryOperator<Integer> somar = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                return n1 + n2;
            }
        };

        // Criar um BinaryOperator que soma dois números com lambda
        BinaryOperator<Integer> somar2 = (n1, n2) -> n1 + n2;

        // Usar o BinaryOperator para somar todos os números no stream
        // usando .reduce(), que recebe dois argumentos o primeiro é a
        // variável temporária que vai ser guardado a soma a cada laço
        // e o seguno é o BinaryOperator
        int resultado = numeros.stream().reduce(0, somar2);

        // voce pode passar direto a lambda no BinaryOperator
        int resultodo2 = numeros.stream().reduce(0, (n1, n2) -> n1 + n2);

        // Uando method reference para somar os elementos
        resultodo2 = numeros.stream().reduce(0, Integer::sum);

        // Imprimir o resultado da soma
        System.out.println("A soma dos número é = "+ resultodo2);


    }
}
