package homeworks.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TextFileProcessor {
    private final String text;

    private long letters = 0;      // буквы
    private long digits = 0;       // цифры
    private long punctuation = 0;  // знаки препинания
    private long spaces = 0;       // пробелы
    private long other = 0;        // остальное

    private TextFileProcessor(String text) {
        this.text = text;
        calculateWithStream();
    }

    public static TextFileProcessor createStatistic(String text) {
        return new TextFileProcessor(text);
    }

    public static boolean checkFileExists(String filePath) {
        Path path = Paths.get(filePath);
        // Проверка существования файла
        if (!Files.exists(path)) {
            System.err.println("Файл не существует: " + path.toAbsolutePath());
            return false;
        }
        return true;
    }


    public static int replaceWord(String filePath, final String searchWord, final String replacementWord) throws IOException {
        int count = 0;
        // конструкция try-with-resources (try со скобками)
        try {
            String text = "Пример ПРИМЕР пример ПрИмЕр";
            String newText = text.replaceAll("(?iu)пример", "замена");
            System.out.println(newText);
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
                    count++;
                }
                // (?i) - игнорирование регистра
                // Замена только целых слов с границами (\b)
                content.append(line.replaceAll("(?iu)" + searchWord, replacementWord)).append("\n");
            }
            reader.close();

            // перезапись файла
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return count;
    }

    public static int copyFile(List<String> filePath1) throws IOException {
        int count = 0;
        // конструкция try-with-resources (try со скобками)
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filePath1));
//            StringBuilder content = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                if (line.toLowerCase().contains(searchWord.toLowerCase())) {
//                    count++;
//                }
//                // (?i) - игнорирование регистра
//                // Замена только целых слов с границами (\b)
//                content.append(line.replaceAll("(?iu)" + searchWord, replacementWord)).append("\n");
//            }
//            reader.close();
//
//            // перезапись файла
//            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
//            writer.write(content.toString());
//            writer.close();
//
//        } catch (IOException e) {
//            throw new IOException(e.getMessage());
//        }
        return count;
    }

    private TextFileProcessor calculateWithStream() {
        letters = text.codePoints().filter(Character::isLetter).count();
        digits = text.codePoints().filter(Character::isDigit).count();
        spaces = text.codePoints().filter(c -> c == ' ').count();
        punctuation = text.codePoints()
                .filter(c -> String.valueOf((char) c).matches("\\p{P}"))
                .count();
        other = text.codePoints().count() - letters - digits - punctuation - spaces;
        return this;
    }

    // @deprecate
    private TextFileProcessor calculate() {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) letters++;
            else if (Character.isDigit(c)) digits++;
            else if (c == ' ') spaces++;
            else if (String.valueOf(c).matches("[\\p{P}\\p{S}]")) punctuation++;
            else other++;
        }
        return this;
    }

    // TODO: т. к. статистика по файлу то класс должен работать не с текстом, а с файлом
    public void show() {
        System.out.println("--------Статистика по файлу-----");
        System.out.println("Буквы: " + letters);
        System.out.println("Цифры: " + digits);
        System.out.println("Знаки препинания: " + punctuation);
        System.out.println("Пробелы: " + spaces);
        System.out.println("Другое: " + other);
        System.out.println("-------------------------------");
    }
}
