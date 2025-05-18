package lessons.Abstraction.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
//        System.out.println(calculate(4, 5, Operation.SUM));
//        System.out.println(calculate(4, 5, Operation.DIFFERENCE));
//        System.out.println(calculate(4, 5, Operation.MULTIPLY));
//        System.out.println(calculate(4, 5, Operation.DIVIDE));
//
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 10);
//        numbers.forEach(n -> System.out.println(n));
//        numbers.forEach(System.out::println);
//
//        numbers.forEach(Main::print); // метод должен содержать переменную Object


        Supplier<Double> randomNumberSupplier = () -> Math.random();
        double randomNumber = randomNumberSupplier.get();
        System.out.println(randomNumber);


        List<String> fruits = Arrays.asList("apple", "orange", "banana", "lemon", "line", "mango");

        fruits.sort((f1, f2) -> Integer.compare(f1.length(), f2.length()));

        fruits.forEach(System.out::println);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static double calculate(double a, double b, Operation operation) {
        return  switch (operation) {
            case SUM -> a + b;
            case DIFFERENCE -> a -b;
            case MULTIPLY -> a * b;
            case DIVIDE -> a / b;
        };
    }
}
