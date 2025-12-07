
import org.apache.commons.lang3.ObjectUtils;
import java.util.Comparator;
import java.util.function.Supplier;

public class ObjectUtilsExamples {
    public static void main(String[] args) {
        // Null handling
        System.out.println(ObjectUtils.allNotNull("a", "b", "c"));
        System.out.println(ObjectUtils.allNull(null, null));
        System.out.println(ObjectUtils.anyNotNull(null, "b", null));
        System.out.println(ObjectUtils.anyNull("a", null));
        System.out.println(ObjectUtils.firstNonNull(null, "default", "backup"));
        System.out.println(ObjectUtils.getIfNull(null, "default"));
        System.out.println(ObjectUtils.getIfNull(null, () -> "default"));
        System.out.println(ObjectUtils.getFirstNonNull(() -> null, () -> "value"));

        // Comparison & Equality
        System.out.println(ObjectUtils.compare("a", "b"));
        System.out.println(ObjectUtils.compare(null, "a", true));
        System.out.println(ObjectUtils.notEqual("a", "b"));

        // Cloning (requires Cloneable implementation)
        // Skipped due to complexity in example

        // Hashing & Identity
        System.out.println(ObjectUtils.hashCodeHex("abc"));
        System.out.println(ObjectUtils.identityHashCodeHex("abc"));
        System.out.println(ObjectUtils.identityToString("abc"));

        // Constants
        final boolean FLAG = ObjectUtils.CONST(true);
        System.out.println("CONST boolean: " + FLAG);
        final byte BYTE_CONST = ObjectUtils.CONST_BYTE(10);
        final short SHORT_CONST = ObjectUtils.CONST_SHORT(100);
        System.out.println("CONST byte: " + BYTE_CONST);
        System.out.println("CONST short: " + SHORT_CONST);

        // Array & Collection Utilities
        System.out.println(ObjectUtils.isArray(new int[]{1, 2}));
        System.out.println(ObjectUtils.isEmpty(""));
        System.out.println(ObjectUtils.isNotEmpty("abc"));

        // Statistical Utilities
        System.out.println(ObjectUtils.max("a", "b", "c"));
        System.out.println(ObjectUtils.min("a", "b", "c"));
        System.out.println(ObjectUtils.median("b", "a", "c"));
        System.out.println(ObjectUtils.median(Comparator.naturalOrder(), "b", "a", "c"));
        System.out.println(ObjectUtils.mode("a", "b", "a"));

        // Validation
        System.out.println(ObjectUtils.requireNonEmpty("abc"));
        System.out.println(ObjectUtils.requireNonEmpty("abc", "Must not be empty"));

        // String Representation
        System.out.println(ObjectUtils.toString(null));
        System.out.println(ObjectUtils.toString(() -> null, () -> "default"));
        System.out.println(ObjectUtils.toString("abc", () -> "default"));

    }
}
