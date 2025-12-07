
import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {

        // 1. Creating Optional instances
        Optional<String> emptyOpt = Optional.empty();
        Optional<String> nonNullOpt = Optional.of("Hello");
        Optional<String> nullableOpt = Optional.ofNullable(null);

        // 2. isPresent and isEmpty
        System.out.println("isPresent: " + nonNullOpt.isPresent());
        System.out.println("isEmpty: " + emptyOpt.isEmpty());

        // 3. ifPresent
        nonNullOpt.ifPresent(value -> System.out.println("Value is: " + value));

        // 4. ifPresentOrElse (Java 9+)
        nonNullOpt.ifPresentOrElse(
            value -> System.out.println("Present: " + value),
            () -> System.out.println("Not Present")
        );

        // 5. orElse
        String result1 = emptyOpt.orElse("Default Value");
        System.out.println("orElse: " + result1);

        // 6. orElseGet
        String result2 = emptyOpt.orElseGet(() -> "Generated Value");
        System.out.println("orElseGet: " + result2);

        // 7. orElseThrow
        try {
            String result3 = emptyOpt.orElseThrow(() -> new RuntimeException("Value not present"));
        } catch (RuntimeException e) {
            System.out.println("orElseThrow: " + e.getMessage());
        }

        // 8. map
        Optional<String> upperOpt = nonNullOpt.map(String::toUpperCase);
        upperOpt.ifPresent(value -> System.out.println("Mapped to upper case: " + value));

        // 9. flatMap
        Optional<Integer> lengthOpt = nonNullOpt.flatMap(value -> Optional.of(value.length()));
        lengthOpt.ifPresent(length -> System.out.println("Length: " + length));

        // 10. filter
        Optional<String> filteredOpt = nonNullOpt.filter(value -> value.startsWith("H"));
        filteredOpt.ifPresent(value -> System.out.println("Filtered value: " + value));

        // 11. Best practices
        String name = getNameSafely(null);
        System.out.println("Safe name: " + name);
    }

    // Example method using Optional to avoid null checks
    public static String getNameSafely(String name) {
        return Optional.ofNullable(name).orElse("Unknown");
    }
}
