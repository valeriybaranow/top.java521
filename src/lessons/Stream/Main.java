package lessons.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*
            Stream - это специальный механизм для работы с последовательностью включая коллекции, массивы и I\O потоки,
            которые могут быть обработаны друг за другом - поток данных которые могут быть быть обработаны последовательно

            упрощенный for цикл

            Создание стрима
            Промежуточные операции - от 0 до "в теории" до бесконечности, для читабельности до 20 операций
            промежуточные операции не работают без терминальной
            терминальная операция обычно одна foreach, collect reduce
            она завершает стрим

            Optional

            после выполнения терминальной операции стрим закрывается и обратиться к нему нельзя

         */

        // создание стрима
        Stream<Integer> streamEmpty = Stream.empty();

        Stream<Integer> streamNumbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        numbers.stream().map(x -> x * x).forEach(System.out::println);

        Stream<Integer> stream = Stream.generate(() -> 1);
//        stream.forEach(System.out::println);

        Stream<Double> stream1 = Stream.generate(Math::random)
                .limit(3);
        stream1.forEach(System.out::println);


        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // Промежуточные операции
        // 1. фильтрация
        numbers2.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        // 2. map - преобразует каждый элемент потока (вытаскивает из объекта поле, например)
        List<String> strings = List.of("aasdf", "bdd", "c");

        strings.stream()
                .map(s -> s.length())
                .forEach(System.out::print);
        // 3. flatMap

        // 4 сортировка
        Stream<Integer> stream2 = Stream.of(100, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        stream2.sorted().forEach(System.out::println);

        // 5. distingt - удаление дубликатов

        // 6.

        List<String> list1 = Arrays.asList();
        Optional<String> first = list1.stream().findFirst();
        System.out.println(first.orElse("apple"));
        System.out.println(first.isPresent());

        // Параллельный стрим
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            lines.add(Double.toHexString(Math.random()));
        }

        // TODO: код ниже содержит ошибку - разобраться
//        long start = System.currentTimeMillis();
//        long count = lines.stream().forEach(s -> {
//            String text = "";
//            for (int i = 0; i < 50; i++) {
//                text += s;
//            }
//            return text.contains("d");
//        }
//
//        ).count();
//        long end = System.currentTimeMillis();
//        System.out.println("Время " + (end - start));
//
//        start = System.currentTimeMillis();
//        count = lines.stream().parallel().forEach(s -> {
//            String text = "";
//            for (int i = 0; i < 50; i++) {
//                text += s;
//            }
//            return text.contains("test");
//        }).count();
//        end = System.currentTimeMillis();
//        System.out.println("Время " + (end - start));

        List<String> names = List.of(
                "Александра",
                "Алексей",
                "Андрей",
                "Валерий",
                "Валерия",
                "Виктор",
                "Вячеслав",
                "Дмитрий",
                "Егор",
                "Елена",
                "Илья",
                "Руслан",
                "Юрий"
        );
//        Collections.shuffle(names);

        Optional<String> anyNames = names.stream().findAny();
        System.out.println(anyNames);
        System.out.println(anyNames);

        Optional<String> anyNames1 = names.parallelStream().findAny();
        System.out.println(anyNames1);
    }
}
