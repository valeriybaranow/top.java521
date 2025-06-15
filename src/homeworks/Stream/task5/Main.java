package homeworks.Stream.task5;


import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
    Обработка данных из файла:
    - Прочитайте содержимое текстового файла в список строк.
    - Используя Stream, отфильтруйте только те строки, которые содержат определенное слово.
    - Подсчитайте количество строк, соответствующих условию.
 */
public class Main {
    public static void main(String[] args) {
        List<String> listForWriting  = Arrays.asList("task1", "task2", "task2", "task4", "task2", "task6");
        Path path = Paths.get("./data/listStrings.txt");

        try {
            Files.write(path, listForWriting, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            List<String> listReading = Files.readAllLines(path, StandardCharsets.UTF_8);
            System.out.println("Список полученный из файла");
            listReading.forEach(System.out::println);
            List<String> listReadingFiltered = listReading.stream().filter(w -> w.equals("task2")).toList();
            System.out.println("Список полученный из файла после фильтрации");
            listReadingFiltered.forEach(System.out::println);
            System.out.println("Количество отфильтрованных значений " + listReadingFiltered.size());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
