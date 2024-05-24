package optional;

import java.util.Optional;

/**
 * O objetivo da classe Optional no Java é fornecer uma abordagem mais segura e expressiva para tratar casos em que um
 * valor pode ser ausente (nulo). Ela foi introduzida a partir do Java 8 para evitar o temido NullPointerException (NPE)
 * que é comum quando se trabalha com referências nulas. Optional permite encapsular um valor que pode ser nulo dentro
 * de um objeto Optional. Isso indica explicitamente que o valor pode ou não estar presente e requer que o código que
 * deseja acessá-lo faça uma verificação explícita.
 */
public class OptimalExample {
    public static void main(String[] args) {
        // of(value): Cria um Optional contendo o valor fornecido. Se o valor for nulo, lançará uma exceção NullPointerException.
        Optional<String> optionalValue = Optional.of("Hello");
        System.out.println("of(value): "+ optionalValue.get());


        // ofNullable(value): Cria um Optional contendo o valor fornecido, mas permite que o valor seja nulo.
        String nullableValue = null;
        Optional<String> optionalValue2 = Optional.ofNullable(nullableValue);
        System.out.println("ofNullable(value): "+ optionalValue2.isPresent());


        // empty(): Retorna um Optional vazio (sem valor).
        Optional<String> optionalValue3 = Optional.empty();
        System.out.println("empty(): "+ optionalValue3.isPresent());


        // isPresent(): Verifica se o Optional contém um valor não nulo.
        Optional<String> optionalValue4 = Optional.of("Hello");
        System.out.println("isPresent(): "+ optionalValue4.isPresent());


        // isEmpty() (A partir do Java 11): Verifica se o Optional está vazio (não contém um valor não nulo).
        Optional<String> optionalValue5 = Optional.ofNullable(null);
        System.out.println("isEmpty() "+ optionalValue5.isEmpty());

        // get(): Obtém o valor contido no Optional. Se o valor for nulo, lançará uma exceção NoSuchElementException.
        Optional<String> optionalValue6 = Optional.of("Hello");
        System.out.println("get(): "+ optionalValue6.get());


        // orElse(defaultValue): Obtém o valor contido no Optional, ou retorna um valor padrão se o Optional estiver vazio
        Optional<String> optionalValue7 = Optional.ofNullable(null);
        String result = optionalValue7.orElse("Default");
        System.out.println("orElse(defaultValue): "+ result);

        // orElseGet(supplier): Obtém o valor contido no Optional, ou retorna um valor fornecido por um Supplier se o Optional estiver vazio.
        Optional<String> optionalValue8 = Optional.ofNullable(null);
        String result1 = optionalValue8.orElseGet(() -> "Value from Supplier");
        System.out.println("orElseGet(supplier): "+ result);

        // orElseThrow(exceptionSupplier): Obtém o valor contido no Optional, ou lança uma exceção fornecida por um Supplier se o Optional estiver vazio.
        Optional<String> optionalValue9 = Optional.ofNullable(null);
        String result2 = optionalValue9.orElseThrow(() -> new RuntimeException("orElseThrow(exceptionSupplier): Value not present"));

        // ifPresent(consumer): Executa uma ação fornecida por um Consumer se o Optional contiver um valor.
        Optional<String> optionalValue10 = Optional.of("Hello");
        optionalValue10.ifPresent(value -> System.out.println("orElseGet(supplier): "+ "Valor presente: " + value));
    }
}
