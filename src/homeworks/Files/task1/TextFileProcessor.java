package homeworks.Files.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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


    public static int replaceWord(String filePath, final String searchWord, final String replacementWord) {
        int lineNumber = 0;
        int contSearch = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.contains(searchWord)) {
                    contSearch++;
                    System.out.println("Слово найдено в строке " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
        return contSearch;
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
