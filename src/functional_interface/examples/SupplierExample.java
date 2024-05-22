package functional_interface.examples;


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
*  Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T.
* É comumente usada para  criar ou fornecer novos objetos de um determinado tipo.
*/
public class SupplierExample {

    public static void main(String[] args) {
        // criar um Supplier com uma mensagem de texto usando lambda
        Supplier<String> mensagem = () -> "Olá, tudo certo?";

        // Criar um Supplier sem lambda
        Supplier<String> mensagem2 = new Supplier<String>() {
            @Override
            public String get() {
                return "Olá, tudo certo?";
            }
        };

        // Usar o Supplier para criar uma lista com 5 mensagens
        List<String> listaMensagens = Stream.generate(mensagem)
                .limit(5)
                .toList();

        // Passando direto a lambda na lista
        List<String> listaMensagens2 = Stream.generate(() -> "Olá, tudo certo?")
                .limit(5)
                .toList();

        // Imprimir a lista
        listaMensagens.forEach(n -> System.out.println(n));

        System.out.println();

        // usando method reference
        listaMensagens.forEach(System.out::println);

    }
}
