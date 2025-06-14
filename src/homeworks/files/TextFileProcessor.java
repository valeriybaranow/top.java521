package homeworks.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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

    public static Map<String, List<StatisticDto>> deleteWords(String filePath, final List<String> words) throws IOException {

        Map<String, List<StatisticDto>> result = new LinkedHashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            StringBuilder content = new StringBuilder();
            String line;
            long numline = 1;
            while ((line = reader.readLine()) != null) {
                for (String word : words) {
                    long countInLine =
                            Pattern.compile("\\b" + word + "\\b", Pattern.CASE_INSENSITIVE).matcher(line).results().count();
                    if (countInLine > 0) {
                        /*
                            Флаги регулярного выражения:
                            - (?iu) - эквивалентно Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
                            - i - case insensitive (игнорирование регистра)
                            - u - Unicode case (корректная работа с не-ASCII символами)
                          n  Границы слова:
                            - \\b - обозначает границу слова (позволяет находить целые слова)
                            Экранирование спецсимволов:
                            - Pattern.quote() - экранирует специальные символы в word
                        */
                        String regex = "(?iu)\\b" + Pattern.quote(word) + "\\b";
                        line.replaceAll(regex, word);
                        // Проверяем, есть ли уже такой ключ
                        StatisticDto statisticDto = new StatisticDto(numline, countInLine);
                        if (result.containsKey(word)) {
                            // Если есть - добавляем в существующий список
                            result.get(word).add(statisticDto);
                        } else {
                            // Если нет - создаем новый список
                            List<StatisticDto> newList = new ArrayList<>();
                            newList.add(statisticDto);
                            result.put(word, newList);
                        }
                    }
                }
                ++numline;
                content.append(line).append("\n");
            }
            reader.close();

            // перезапись файла
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content.toString());
            writer.close();

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
        return result;
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

    public static int replaceWords(String filePath, final String searchWord, final String replacementWord) throws IOException {
        int count = 0;
        // конструкция try-with-resources (try со скобками)
        try {
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

    public record StatisticDto(long line, long count) {
    }

    public static <T> void saveObjects(String filePath, List<T> list) {
        for (final T object : list) {
            // Запись объекта в файл
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(filePath))) {
                oos.writeObject(object);
                System.out.println("Объект записан в файл");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static <T> T[] readObjects(String filePath) {
        // Чтение массива из файла
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            T[] loaded = (T[]) ois.readObject();
            System.out.println("Прочитанный массив:");
            for (T p : loaded) {
                System.out.println(p);
            }
            return loaded;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int copyFile(List<String> filePaths) throws IOException {
        StringBuilder content = new StringBuilder();
        int butes = 0;
        int i = 1;
        for (final String filePath : filePaths) {
            Path path = Paths.get(String.valueOf(filePath));
            if (i < filePaths.size()) {
                String fileText = Files.readString(path).toString();
                content.append(fileText).append("\n");
                butes += fileText.getBytes().length;
            } else {
                // перезапись файла
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
                writer.write(content.toString());
                writer.close();
            }
            ++i;
        }
        return butes;
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
