package exams.java;

import homeworks.files.taskfive.Contact;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
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

    public static List<String> readFile(Path filePath) throws IOException {
        List<Charset> encodings = Arrays.asList(
                StandardCharsets.UTF_8,
                StandardCharsets.ISO_8859_1,
                Charset.forName("Windows-1251"),
                StandardCharsets.UTF_16
        );

        List<String> content = new ArrayList<>();
        IOException lastException = null;

        for (Charset encoding : encodings) {
            try {
                content.clear(); // Очищаем на случай предыдущих попыток
                try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.add(line);
                    }
                    return content; // Успешное чтение
                }
            } catch (MalformedInputException | UnmappableCharacterException e) {
                lastException = e;
                continue;
            }
        }

        throw new IOException("Не удалось прочитать файл с доступными кодировками", lastException);
    }

    // TODO: метод нужно удалить
    public static List<Contact> readObjects(String filePath) {
        List<Contact> objects = new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filePath))) {
            int count = ois.readInt();

            for (int i = 0; i < count; i++) {
                Contact object = (Contact) ois.readObject();
                objects.add(object);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return objects;
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

        @Override
        public String toString() {
            return "FileInfo{" +
                    "name='" + name + '\'' +
                    ", mode=" + mode +
                    ", size=" + size +
                    ", author='" + author + '\'' +
                    ", creationTime=" + creationTime +
                    '}';
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
