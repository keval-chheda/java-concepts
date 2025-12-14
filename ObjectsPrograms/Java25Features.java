
// Java 25 Feature Examples
// Note: Some features require --enable-preview and --add-modules flags during compilation and execution

// JEP 507: Primitive Types in Patterns
class PrimitivePatternMatching {
    static void test(Object obj) {
        if (obj instanceof Integer i) {
            System.out.println("It's an int: " + i);
        } else {
            System.out.println("Not an int");
        }
    }
}

// JEP 511: Module Import Declarations
// Note: This is a preview feature and requires --enable-preview
// import module java.base;
// import module java.sql;
// import java.sql.Date;

// JEP 512: Compact Source Files and Instance Main Methods
// This feature allows writing Java programs without class declarations
// Example:
// void main() {
//     System.out.println("Hello from Java 25!");
// }

// JEP 513: Flexible Constructor Bodies
class Person {
    final int age;
    Person(int age) {
        this.age = age;
    }
}

class Employee extends Person {
    final String name;
    Employee(String name, int age) {
        if (age < 18 || age > 67) throw new IllegalArgumentException("Age must be between 18 and 67");
        super(age); // super() is no longer required as the first statement
        this.name = name;
    }
}

// JEP 506: Scoped Values
// Requires --enable-preview and Java 25
// import java.lang.ScopedValue;
// Example usage with virtual threads

// JEP 505: Structured Concurrency
// Requires --enable-preview
// import java.util.concurrent.StructuredTaskScope;

// JEP 502: Stable Values
// import java.lang.StableValue;
// Example:
// var greeting = StableValue.<String>of();
// String message = greeting.orElseSet(() -> "Hello from StableValue!");

// JEP 470: PEM Encodings
// Example of reading a PEM encoded public key
// Requires java.security and java.util.Base64

// JEP 508: Vector API
// Requires --enable-preview --add-modules jdk.incubator.vector
// import jdk.incubator.vector.*;

// JEP 510: Key Derivation Function API
// Example:
// import javax.crypto.SecretKey;
// import javax.crypto.SecretKeyFactory;
// import javax.crypto.spec.PBEKeySpec;

public class Java25Features {
    public static void main(String[] args) {
        System.out.println("Java 25 Feature Demonstration");
        PrimitivePatternMatching.test(42);
        PrimitivePatternMatching.test("Hello");

        Employee emp = new Employee("Alice", 35);
        System.out.println("Employee created: " + emp.name + ", Age: " + emp.age);
    }
}
