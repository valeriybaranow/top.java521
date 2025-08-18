package exams.java;

import homeworks.files.taskfive.IllegalEmailException;
import homeworks.files.taskfive.IllegalPhoneException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class FileManager {
    private static final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    private final static String TABLE_HEAD_FORMAT = "| %-10s | %-18s | %-12s | %-19s | %-19s |%n";
    private static List<String> fileLines;
    private static int countLines = 50;
    private static int currentLine = 0;
    private final String[] menuShowFolderItems = {"сменить папку", "показать файл", "поиск", "замена", "создать", "сортировать", "выход"};
    private String title;
    private static FileManager instance;

    private static Path currentPath = Paths.get("C:\\Users\\valeriy\\IdeaProjects\\top.java521");

    private Integer[] menuItems = {0, -1};
    private int totalWidth = 90;

    public static FileManager instance(String title) {
        if (instance == null) {
            instance = new FileManager(title);
        }
        return instance;
    }

    private FileManager(String title) {
        this.title = title;
    }

    public static Path getCurrentPath() {
        return currentPath;
    }

    public static void setPrevCurrentPath() {
        currentPath = currentPath.getParent();
    }

    public static boolean checkCurrentPath(String pathDir, Path currentPath) {
        if (pathDir == null || pathDir.trim().isEmpty()) {
            FileManager.printError("Путь не может быть пустым");
            return false;
        }

        if (pathDir.startsWith("//") || pathDir.startsWith("\\\\")) {
            FileManager.printError("Некорректный формат пути: " + pathDir);
            return false;
        }

        try {
            Path currentPathNew = currentPath.resolve(pathDir).normalize();
            if (!Files.exists(currentPathNew)) {
                FileManager.printError("Папка " + currentPathNew + " не существует");
                return false;
            }

            return true;
        } catch (InvalidPathException ex) {
            FileManager.printError("Некорректный путь: " + pathDir + " - " + ex.getMessage());
            return false;
        } catch (SecurityException ex) {
            FileManager.printError("Нет доступа к пути: " + pathDir);
            return false;
        }
    }

    private static String truncateStringWithEllipsis(String str, int maxLength) {
        if (str == null) {
            return null;
        }
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength - 3) + "...";
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = Integer.parseInt(scanner.nextLine());

                if (value >= min && value <= max) {
                    return value;
                }
                printMessage(String.format("Введите число от %d до %d\n", min, max));
            } catch (NumberFormatException e) {
                printMessage("Введите целое число");
            }
        }
    }

    public static void printMessage(String message) {
        System.out.println(ConsoleColors.GREEN + message + ConsoleColors.RESET);
    }

    public static void printError(String error) {
        System.out.println(ConsoleColors.RED + error + ConsoleColors.RESET);
    }

    private static void printSeparatorLine() {
        System.out.println("==============================================================================================");
    }

    private static void printPageNumber() {
        System.out.printf("| %-90s |%n", "");
        int totalLines = fileLines.size();
        int totalPages = (int) Math.ceil((double) totalLines / countLines);
        int currentPage = (currentLine / countLines) + 1;
        String pageInfo = String.format("Страница %d из %d", currentPage, totalPages);

        int totalWidth = 90;
        int infoWidth = pageInfo.length();
        int sideWidth = (totalWidth - infoWidth) / 2;

        String emptyLine = String.format("| %-" + totalWidth + "s |%n", "");
        String pageLine = String.format("| %-" + sideWidth + "s%s%-" + sideWidth + "s |%n",
                "", pageInfo, "");

        System.out.print(emptyLine + pageLine);
    }

    private static void finishApp() {
        printMessage("Выход из программы...");
        scanner.close();
        System.exit(0);
    }

    public void setMenuItemsLevelTwo(int levelTwo) {
        this.menuItems[1] = levelTwo;
    }

    public void start(Consumer<Integer[]> actionHandler) {
        while (true) {
            printMenu(menuShowFolderItems);
            int menuItem = readInt("Выберите пункт меню: ", 1, menuShowFolderItems.length);

            if (menuItems[1] == -1) {
                if (menuItem == menuShowFolderItems.length) {
                    finishApp();
                    break;
                }
                menuItems[0] = menuItem - 1;
            } else {
                menuItems[1] = menuItem - 1;
            }

            actionHandler.accept(menuItems);
        }
    }

    public void changeDir(String pathDir) {
        if (checkCurrentPath(pathDir, currentPath)) {
            currentPath = currentPath.resolve(pathDir).normalize();
            refreshDir();
        }
    }

    public void showDir() {
        clearConsole();
        printTitle(title);
        System.out.printf(TABLE_HEAD_FORMAT, "Тип", "Имя", "Размер, байт", "Дата создания", "Автор");
        printSeparatorLine();
        System.out.printf("| %-90s |%n", currentPath.toAbsolutePath().normalize());
        TextFileProcessor.foundFiles.forEach(foundFile -> {
            System.out.printf(
                    TABLE_HEAD_FORMAT,
                    foundFile.getMode(),
                    truncateStringWithEllipsis(foundFile.getName(), 18),
                    truncateStringWithEllipsis(Long.toString(foundFile.getSize()), 12),
                    DateTimeFormatter.ofPattern("YYYY.mm.dd hh:mm:ss")
                            .withZone(ZoneId.systemDefault())
                            .format(foundFile.getCreationTime().toInstant()),
                    truncateStringWithEllipsis(foundFile.getAuthor(), 19)
            );
        });
        printSeparatorLine();

    }

    public void refreshDir() {
        try {
            TextFileProcessor.saveStructureFolder(currentPath);
            if (TextFileProcessor.isError) {
                TextFileProcessor.foundFiles.clear();
                TextFileProcessor.isError = false;
                return;
            }
            showDir();
        } catch (IllegalPhoneException | IllegalEmailException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void checkAndShowFile(String pathFile) {
        if (checkCurrentPath(pathFile, currentPath)) {
            currentPath = currentPath.resolve(pathFile).normalize();
            showFile();
        }
    }

    private void showFile() {
        try {
            clearConsole();
            fileLines = TextFileProcessor.readFile(currentPath);
            printTitle(title);
            System.out.printf("| %-90s |%n", currentPath.toAbsolutePath().normalize());
            printSeparatorLine();
            fileLines.stream().skip(currentLine).limit(countLines).forEach(item -> {
                        System.out.printf("| %-90s |%n", item);
                    }
            );
            printPageNumber();
            printSeparatorLine();
            Arrays.stream(MenuShowFileItem.values()).forEach(item -> item.displayIfAllowed());

            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void findWordInFile(String pathFile, String word) {
        if (checkCurrentPath(pathFile, currentPath)) {
            currentPath = currentPath.resolve(pathFile).normalize();
            clearConsole();
            try {
                fileLines = TextFileProcessor.readFile(currentPath);
                printTitle("Поиск в файле");
                System.out.printf("| %-90s |%n", currentPath.toAbsolutePath().normalize());
                printSeparatorLine();

                long count = fileLines.stream()
                        .filter(item -> item.toLowerCase().contains(word.toLowerCase()))
                        .count();

                fileLines
                        .stream()
                        .filter(item -> {
                            return item.toLowerCase(Locale.forLanguageTag("ru"))
                                    .contains(word.toLowerCase(Locale.forLanguageTag("ru")));
                        })
                        .forEach(item -> System.out.printf("| %-90s |%n", item));
                printSeparatorLine();
                Arrays.stream(MenuFindWordInFile.values()).forEach(item -> item.displayIfAllowed());
                System.out.println();
                System.out.printf("Найдено совпадений: %d%n", count);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void replaceWordInFile(String pathFile, String oldWord, String newWord) {
        if (checkCurrentPath(pathFile, currentPath)) {
            currentPath = currentPath.resolve(pathFile).normalize();
            clearConsole();
            try {
                printTitle("Замена слова в файле");
                System.out.printf("| %-90s |%n", currentPath.toAbsolutePath().normalize());
                printSeparatorLine();

                int count = 0;
                try {
                    BufferedReader reader = Files.newBufferedReader(currentPath, StandardCharsets.UTF_8);
                    StringBuilder content = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (line.toLowerCase().contains(oldWord.toLowerCase())) {
                            System.out.printf("| %-90s |%n", line);
                            count++;
                        }
                        content.append(line.replaceAll("(?iu)" + oldWord, newWord)).append("\n");
                    }
                    reader.close();

                    BufferedWriter writer = Files.newBufferedWriter(currentPath, StandardCharsets.UTF_8);
                    writer.write(content.toString());
                    writer.close();

                } catch (IOException e) {
                    throw new IOException(e.getMessage());
                }

                printSeparatorLine();
                Arrays.stream(MenuFindWordInFile.values()).forEach(item -> item.displayIfAllowed());
                System.out.println();
                System.out.printf("Было произведено замен: %d%n", count);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createFile(String filePath) {
        Path newFilePath = currentPath.resolve(filePath);
        clearConsole();
        try (BufferedWriter writer = Files.newBufferedWriter(newFilePath,
                StandardCharsets.UTF_8)) {
            writer.write("Это содержимое нового файла");
            printMessage("Файл успешно создан: " + newFilePath.toAbsolutePath());
        } catch (IOException e) {
            printMessage("Ошибка при создании файла: " + e.getMessage());
        }
    }

    public void sortFileInDir(int index) {
        clearConsole();

        if (TextFileProcessor.foundFiles == null || TextFileProcessor.foundFiles.isEmpty()) {
            printMessage("Нет файлов для сортировки");
            return;
        }

        try {
            MenuColumnItems sortBy = MenuColumnItems.getByIndex(index);
            String sortMessage = "Файлы отсортированы по ";

            switch (sortBy) {
                case SIZE -> {
                    TextFileProcessor.foundFiles.sort(Comparator.comparingLong(TextFileProcessor.FileInfo::getSize));
                    sortMessage += "размеру";
                }
                case AUTHOR -> {
                    TextFileProcessor.foundFiles.sort(Comparator.comparing(
                            file -> file.getAuthor() != null ? file.getAuthor().toLowerCase() : "",
                            Comparator.nullsLast(Comparator.naturalOrder())
                    ));
                    sortMessage += "автору";
                }
                case CREATION_DATE -> {
                    TextFileProcessor.foundFiles.sort(Comparator.comparing(
                            TextFileProcessor.FileInfo::getCreationTime,
                            Comparator.nullsLast(Comparator.naturalOrder())
                    ));
                    sortMessage += "дате создания";
                }
                case NAME -> {
                    TextFileProcessor.foundFiles.sort(Comparator.comparing(
                            file -> file.getName().toLowerCase())
                    );
                    sortMessage += "имени";
                }
            }

            printMessage(sortMessage);
        } catch (IllegalArgumentException e) {
            printMessage("Ошибка: " + e.getMessage());
        }
    }

    public void showFileNext(String pathFile) {
        if (MenuShowFileItem.isNextPageAvailable()) {
            currentLine += countLines;
            showFile();
        }
    }

    public void showFilePrev(String pathFile) {
        if (MenuShowFileItem.isPrevPageAvailable()) {
            currentLine -= countLines;
            showFile();
        }
    }

    private void printMenu(String[] menuItems) {
        for (int i = 0; i < menuItems.length; i++) {
            String separator = i != (menuItems.length - 1) ? " | " : "";
            String message = String.format("%s - %d%s", menuItems[i], i + 1, separator);
            System.out.printf(ConsoleColors.GREEN + message + ConsoleColors.RESET);
        }
        System.out.println();
    }

    class ConsoleColors {
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        public static final String BRIGHT_GREEN = "\u001B[92m";

        public static final String RESET = "\u001B[0m";

        public static void printColored(String color, String message) {
            System.out.println(color + message + RESET);
        }
    }

    public void resetFileCurrenLine() {
        currentLine = 0;
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void printTitle(String title) {
        String safeTitle = title == null ? "" : title;
        int maxTitleWidth = this.totalWidth - 4; // Учет границ и отступов

        String displayTitle = safeTitle.length() > maxTitleWidth
                ? safeTitle.substring(0, maxTitleWidth - 3) + "..."
                : safeTitle;

        int titleWidth = displayTitle.length();
        int totalPadding = this.totalWidth - titleWidth;

        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;

        String leftSide = repeatString("=", leftPadding - 1);
        String rightSide = repeatString("=", rightPadding - 1);

        System.out.printf("| %s %s %s |%n", leftSide, displayTitle, rightSide);
    }

    private String repeatString(String str, int count) {
        if (count <= 0) return "";
        return new String(new char[count]).replace("\0", str);
    }

    // TODO: меню не защищено от ошибок, если ввести текст то выдает ошибку
    enum MenuColumnItems {
        NAME(0, "имя"),
        SIZE(1, "размер"),
        AUTHOR(2, "автор"),      // Исправлена опечатка (было AUTНOR)
        CREATION_DATE(3, "дата создания");

        private final int index;
        private final String displayName;

        MenuColumnItems(int index, String displayName) {
            this.index = index;
            this.displayName = displayName;
        }

        public static MenuColumnItems getByIndex(int index) {
            for (MenuColumnItems item : values()) {
                if (item.index == index) {
                    return item;
                }
            }
            throw new IllegalArgumentException("Неизвестный индекс: " + index);
        }

        public void displayIfAllowed() {
            String separator = this != values()[values().length - 1] ? " | " : "";
            System.out.print(ConsoleColors.GREEN + displayName + " - " + index + separator + ConsoleColors.RESET);
        }
    }

    enum MenuFindWordInFile {
        BACK(1, "назад");

        private final String name;
        private final int index;

        MenuFindWordInFile(int index, String name) {
            this.name = name;
            this.index = index;
        }

        public void displayIfAllowed() {
            display();
        }

        private void display() {
            String separator = this != values()[values().length - 1] ? " | " : "";
            System.out.print(ConsoleColors.GREEN + name + " - " + index + separator + ConsoleColors.RESET);
        }
    }

    enum MenuShowFileItem {
        NEXT_PAGE(1, "следующая страница"),
        PREV_PAGE(2, "предыдущая страницы"),
        BACK(3, "назад");

        private final String name;
        private final int index;

        MenuShowFileItem(int index, String name) {
            this.name = name;
            this.index = index;
        }

        private static boolean isNextPageAvailable() {
            return currentLine + countLines < fileLines.size();
        }

        private static boolean isPrevPageAvailable() {
            return currentLine - countLines >= 0;
        }

        public void displayIfAllowed() {
            if (shouldDisplay()) {
                display();
            }
        }

        private boolean shouldDisplay() {
            return switch (this) {
                case NEXT_PAGE -> isNextPageAvailable();
                case PREV_PAGE -> isPrevPageAvailable();
                case BACK -> true;
            };
        }

        private void display() {
            String separator = this != values()[values().length - 1] ? " | " : "";
            System.out.print(ConsoleColors.GREEN + name + " - " + index + separator + ConsoleColors.RESET);
        }
    }
}
