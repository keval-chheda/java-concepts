
import java.util.function.*;

public class FunctionalInterfacesExamples {
    public static void main(String[] args) {

        // 1. Predicate: tests a condition and returns boolean
        Predicate<String> isNotEmpty = str -> str != null && !str.isEmpty();
        System.out.println("Predicate test: " + isNotEmpty.test("Hello"));

        // 2. Function: takes one argument and returns a result
        Function<String, Integer> stringLength = str -> str.length();
        System.out.println("Function apply: " + stringLength.apply("Hello"));

        // 3. Consumer: takes one argument and returns nothing
        Consumer<String> printUpper = str -> System.out.println(str.toUpperCase());
        printUpper.accept("hello");

        // 4. Supplier: takes no argument and returns a result
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Supplier get: " + randomSupplier.get());

        // 5. UnaryOperator: a Function where input and output are same type
        UnaryOperator<String> toLower = str -> str.toLowerCase();
        System.out.println("UnaryOperator apply: " + toLower.apply("HELLO"));

        // 6. BinaryOperator: a BiFunction where inputs and output are same type
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("BinaryOperator apply: " + add.apply(5, 3));

        // 7. Custom Functional Interface
        Greeting greeting = name -> "Hello, " + name;
        System.out.println("Custom Functional Interface: " + greeting.sayHello("Alice"));
    }

    // Custom functional interface
    @FunctionalInterface
    interface Greeting {
        String sayHello(String name);
    }
}
