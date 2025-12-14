
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.Predicate;

import java.util.*;

public class CollectionUtilsExamples {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("apple", "banana", "cherry", "date");
        List<String> list2 = Arrays.asList("banana", "date", "fig", "grape");

        // 1. isEmpty and isNotEmpty
        System.out.println("isEmpty: " + CollectionUtils.isEmpty(list1));
        System.out.println("isNotEmpty: " + CollectionUtils.isNotEmpty(list2));

        // 2. intersection
        Collection<String> intersection = CollectionUtils.intersection(list1, list2);
        System.out.println("Intersection: " + intersection);

        // 3. union
        Collection<String> union = CollectionUtils.union(list1, list2);
        System.out.println("Union: " + union);

        // 4. subtract
        Collection<String> subtract = CollectionUtils.subtract(list1, list2);
        System.out.println("Subtract (list1 - list2): " + subtract);

        // 5. disjunction
        Collection<String> disjunction = CollectionUtils.disjunction(list1, list2);
        System.out.println("Disjunction: " + disjunction);

        // 6. select (filter elements based on a predicate)
        Predicate<String> startsWithB = str -> str.startsWith("b");
        Collection<String> selected = CollectionUtils.select(list1, startsWithB);
        System.out.println("Selected (starts with 'b'): " + selected);

        // 7. filter (modifies the original collection)
        List<String> mutableList = new ArrayList<>(list1);
        CollectionUtils.filter(mutableList, str -> str.length() > 5);
        System.out.println("Filtered (length > 5): " + mutableList);

        // 8. transform (apply transformation to each element)
        List<String> transformList = new ArrayList<>(list1);
        CollectionUtils.transform(transformList, (Transformer<String, String>) str -> str.toUpperCase());
        System.out.println("Transformed to upper case: " + transformList);

        // 9. collate (merge two sorted collections)
        List<Integer> nums1 = Arrays.asList(1, 3, 5);
        List<Integer> nums2 = Arrays.asList(2, 4, 6);
        Collection<Integer> collated = CollectionUtils.collate(nums1, nums2);
        System.out.println("Collated: " + collated);
    }
}
