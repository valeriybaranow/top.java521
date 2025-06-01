package lessons.workWithFile.task1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> todo  = Arrays.asList("task1", "task2", "task3", "task4", "task5", "task6");

        Path path = Paths.get("./data/todoList.txt");

        try {
            Files.write(path, todo, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
            Files.write(path, "task7\n".getBytes(), StandardOpenOption.APPEND);

            Files.readAllLines(path).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
