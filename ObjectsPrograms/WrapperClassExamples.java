
public class WrapperClassExamples {
    public static void main(String[] args) {
        // Byte
        Byte byteObj = Byte.valueOf((byte) 10);
        System.out.println("Byte: " + byteObj);
        System.out.println("Byte to int: " + byteObj.intValue());

        // Short
        Short shortObj = Short.valueOf((short) 100);
        System.out.println("Short: " + shortObj);
        System.out.println("Short to double: " + shortObj.doubleValue());

        // Integer
        Integer intObj = Integer.valueOf(200);
        System.out.println("Integer: " + intObj);
        System.out.println("Integer to float: " + intObj.floatValue());
        System.out.println("Integer parse: " + Integer.parseInt("123"));

        // Long
        Long longObj = Long.valueOf(1000L);
        System.out.println("Long: " + longObj);
        System.out.println("Long to int: " + longObj.intValue());

        // Float
        Float floatObj = Float.valueOf(10.5f);
        System.out.println("Float: " + floatObj);
        System.out.println("Float to int: " + floatObj.intValue());

        // Double
        Double doubleObj = Double.valueOf(99.99);
        System.out.println("Double: " + doubleObj);
        System.out.println("Double to long: " + doubleObj.longValue());

        // Character
        Character charObj = Character.valueOf('A');
        System.out.println("Character: " + charObj);
        System.out.println("Is letter: " + Character.isLetter(charObj));
        System.out.println("To lowercase: " + Character.toLowerCase(charObj));

        // Boolean
        Boolean boolObj = Boolean.valueOf(true);
        System.out.println("Boolean: " + boolObj);
        System.out.println("Boolean parse: " + Boolean.parseBoolean("false"));
    }
}
