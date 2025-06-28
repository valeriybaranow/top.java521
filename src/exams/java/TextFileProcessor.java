package exams.java;

import homeworks.files.taskfive.Contact;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class TextFileProcessor {
    public static List<FileInfo> foundFiles = new ArrayList<>();
    public static boolean isError = false;

    public static void saveStructureFolder(Path currentPath) throws IOException {
        TextFileProcessor.foundFiles.clear();
        TextFileProcessor.isError = false;
        PrintFiles pf = new PrintFiles(currentPath);
        Files.walkFileTree(currentPath, pf);
    }

    public static boolean checkFileExists(Path currentPath) {
        // Проверка существования файла
        if (!Files.exists(currentPath)) {
            return false;
        }
        return true;
    }

    public static List<String> readFile(Path filePath) throws IOException {
        List<String> content = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        }
        return content;
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

    public static void saveObjects(String filePath, List<Contact> list) {
        // Запись объекта в файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // Записываем количество объектов
            oos.writeInt(list.size());
            for (final Contact object : list) {
                oos.writeObject(object);
            }
            System.out.println("Объект записан в файл");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Contact> readObjects(String filePath) {
        List<Contact> objects = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            // Читаем количество объектов
            int count = ois.readInt();

            // Читаем объекты в цикле
            for (int i = 0; i < count; i++) {
                Contact object = (Contact) ois.readObject();
                objects.add(object);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return objects;
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

    public static class FileInfo {
        private String name;
        private Mode mode;
        private long size;
        private String author = "";
        private FileTime creationTime;

        public Mode getMode() {
            return mode;
        }

        public void setMode(Mode mode) {
            this.mode = mode;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public FileTime getCreationTime() {
            return creationTime;
        }

        public void setCreationTime(FileTime dateCreated) {
            this.creationTime = dateCreated;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public enum Mode {
            SYMLINK, FILE, FOLDER, OTHER
        }
    }

    public static class PrintFiles extends SimpleFileVisitor<Path> {
        private final Path startDir;

        public PrintFiles(Path startDir) {
            this.startDir = startDir;
        }

        @Override
        public FileVisitResult visitFile(Path dir, BasicFileAttributes attr) {
            if (dir.equals(startDir)) {
                return FileVisitResult.CONTINUE;
            }

            FileInfo fileInfo = new FileInfo();
            if (attr.isSymbolicLink()) {
                fileInfo.setMode(FileInfo.Mode.SYMLINK);
            } else if (attr.isRegularFile()) {
                fileInfo.setMode(FileInfo.Mode.FILE);
            } else if (attr.isDirectory()) {
                fileInfo.setMode(FileInfo.Mode.FOLDER);
            } else if (attr.isOther()) {
                fileInfo.setMode(FileInfo.Mode.OTHER);
            }
            fileInfo.setName(dir.getFileName().toString());
            try {
                UserPrincipal owner = Files.getOwner(dir);
                fileInfo.setAuthor(owner.getName());
            } catch (IOException e) {
                isError = true;
                FileManager.printError(e.getMessage());
            }

            fileInfo.setSize(attr.size());
            fileInfo.setCreationTime(attr.creationTime());

            foundFiles.add(fileInfo);

            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
            if (dir.equals(startDir)) {
                return FileVisitResult.CONTINUE;
            }
            BasicFileAttributes attr = null;
            try {
                attr = Files.readAttributes(dir, BasicFileAttributes.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            FileInfo fileInfo = new FileInfo();
            fileInfo.setMode(FileInfo.Mode.FOLDER);
            fileInfo.setName(dir.getFileName().toString());
            fileInfo.setSize(attr.size());
            fileInfo.setCreationTime(attr.creationTime());
            foundFiles.add(fileInfo);

            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc.getMessage());
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}
