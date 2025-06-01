package lessons.workWithFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {


    }

    public static void part3() throws IOException {
        try {
            Stream<String> stream = Files.lines(Paths.get("./data/info.txt"));
            stream
                    .filter(line -> !line.isEmpty())
                    .forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void part2() throws IOException {
        Path path = Paths.get("data/info.txt");
        List<String> lines = Files.readAllLines(path);
//        Files.lines(path).forEach(System.out::println);
        lines.forEach(System.out::println);

        // запись в файл
        String text = "Новая строчка";
        Files.write(path, text.getBytes(), StandardOpenOption.APPEND);

        List<String> newLines = Arrays.asList(";alksdjf;las", ";askdf;as");
        Files.write(path, newLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    public static void part1() throws IOException {
        // java.io - input output - java1 File BufferedReader, BufferedWriter, FileWriter
        // FileInputStream, FileOutputStream - для работы с байтами

        File file = new File("./data/info.txt");
        System.out.println(file.createNewFile());
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        boolean delete = file.delete();

        File dir = new File("./my Folder");
        boolean isMkdir = dir.mkdir();
        System.out.println(isMkdir);

        File dir2 = new File("./example/my Folder");
        System.out.println(dir.mkdirs());

        File dir1 = new File("C:/test/test");
        System.out.println(dir1.mkdir());

        // java.nio new io - java 7 - Files, Path, Paths

        Path path = Paths.get("C:/test");
        Files.list(path)
                .filter(Files::isRegularFile)
                .forEach(System.out::println);

        Files.list(path)
                .filter(Files::isRegularFile)
                .forEach(f -> {
                    try {
                        Files.delete(f.toAbsolutePath());
                        System.out.println("Удален файл " + f.toAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Файлы не найдены");
                        throw new RuntimeException(e);
                    }
                });

        Path dir4 = Paths.get("folder/test");
        Files.createDirectories(dir4);
        Files.delete(dir4);
        Files.delete(Paths.get("folder"));
    }
}
