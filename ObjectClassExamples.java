
public class ObjectClassExamples {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Create sample objects
        ObjectClassExamples obj1 = new ObjectClassExamples();
        ObjectClassExamples obj2 = new ObjectClassExamples();

        // toString()
        System.out.println("toString(): " + obj1.toString());

        // equals(Object obj)
        System.out.println("equals(): " + obj1.equals(obj2));
        System.out.println("equals() with same object: " + obj1.equals(obj1));

        // hashCode()
        System.out.println("hashCode(): " + obj1.hashCode());

        // getClass()
        System.out.println("getClass(): " + obj1.getClass().getName());

        // clone() - requires implementing Cloneable
        CloneableExample cloneObj = new CloneableExample(10);
        CloneableExample cloned = (CloneableExample) cloneObj.clone();
        System.out.println("Original value: " + cloneObj.getValue());
        System.out.println("Cloned value: " + cloned.getValue());

        // finalize() - deprecated and not recommended for use
        // Java 9 and above discourage using finalize()
        // So we will not demonstrate finalize() here
    }
}

class CloneableExample implements Cloneable {
    private int value;

    public CloneableExample(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
