import java.util.*;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<String> foods = new ArrayList<>();
        foods.add("apple");
        foods.add("banana");
        foods.add("cherry");
        // Print the element at index 1
        System.out.println(foods.get(1));

        // Remove the element at index 1
        System.out.println(foods.remove(1));

        // Print the element at index 1 again
        System.out.println(foods.get(1));
    }
}