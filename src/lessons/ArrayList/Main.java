package lessons.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println(numbers);
    }
}
