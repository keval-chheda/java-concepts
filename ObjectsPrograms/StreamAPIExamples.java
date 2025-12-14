
import java.util.*;
import java.util.stream.*;
import java.nio.file.*;
import java.io.IOException;

public class StreamAPIExamples {
    public static void main(String[] args) throws IOException {

        // 1. Stream Creation
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        Stream<String> streamFromList = names.stream();
        Stream<String> streamFromArray = Arrays.stream(new String[]{"X", "Y", "Z"});
        Stream<String> streamOf = Stream.of("One", "Two", "Three");
        Stream<Double> generatedStream = Stream.generate(Math::random).limit(5);
        Stream<Integer> iteratedStream = Stream.iterate(0, n -> n + 2).limit(5);
        Stream<String> fileStream = Files.lines(Paths.get("sample.txt")); // Requires sample.txt

        // 2. Intermediate Operations
        List<String> filtered = names.stream()
            .filter(name -> name.startsWith("A"))
            .collect(Collectors.toList());

        List<Integer> mapped = Arrays.asList(1, 2, 3).stream()
            .map(n -> n * n)
            .collect(Collectors.toList());

        List<String> flatMapped = Arrays.asList("a,b", "c,d").stream()
            .flatMap(s -> Arrays.stream(s.split(",")))
            .collect(Collectors.toList());

        List<String> distinctNames = Arrays.asList("Alice", "Bob", "Alice").stream()
            .distinct()
            .collect(Collectors.toList());

        List<String> sortedNames = names.stream()
            .sorted()
            .collect(Collectors.toList());

        List<String> peeked = names.stream()
            .peek(System.out::println)
            .collect(Collectors.toList());

        List<String> limited = names.stream()
            .limit(3)
            .collect(Collectors.toList());

        List<String> skipped = names.stream()
            .skip(2)
            .collect(Collectors.toList());

        // 3. Terminal Operations
        names.stream().forEach(System.out::println);

        List<String> collected = names.stream()
            .collect(Collectors.toList());

        int sum = Arrays.asList(1, 2, 3, 4).stream()
            .reduce(0, Integer::sum);

        long count = names.stream().count();

        boolean anyMatch = names.stream().anyMatch(n -> n.startsWith("A"));
        boolean allMatch = names.stream().allMatch(n -> n.length() > 2);
        boolean noneMatch = names.stream().noneMatch(n -> n.isEmpty());

        Optional<String> first = names.stream().findFirst();
        Optional<String> any = names.stream().findAny();

        Object[] array = names.stream().toArray();

        // 4. Collectors
        String joined = names.stream().collect(Collectors.joining(", "));

        Map<Integer, List<String>> groupedByLength = names.stream()
            .collect(Collectors.groupingBy(String::length));

        Map<Boolean, List<String>> partitioned = names.stream()
            .collect(Collectors.partitioningBy(s -> s.length() > 3));

        IntSummaryStatistics stats = Arrays.asList(1, 2, 3, 4, 5).stream()
            .collect(Collectors.summarizingInt(Integer::intValue));

        double average = Arrays.asList(1, 2, 3, 4, 5).stream()
            .collect(Collectors.averagingInt(Integer::intValue));

        // 5. Primitive Streams
        IntStream intStream = IntStream.range(1, 5);
        IntStream intStreamClosed = IntStream.rangeClosed(1, 5);

        // 6. Optional Handling
        Optional<String> optionalName = names.stream().filter(n -> n.startsWith("Z")).findFirst();
        optionalName.ifPresentOrElse(System.out::println, () -> System.out.println("Not found"));

        // 7. Parallel Streams
        List<String> parallelNames = names.parallelStream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        // 8. Debugging with peek
        List<String> debugged = names.stream()
            .peek(n -> System.out.println("Processing: " + n))
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        // 9. Custom Collector
        Collector<String, ?, String> customCollector = Collector.of(
            StringBuilder::new,
            StringBuilder::append,
            StringBuilder::append,
            StringBuilder::toString
        );
        String customCollected = names.stream().collect(customCollector);
        System.out.println("Custom Collected: " + customCollected);
    }
}
