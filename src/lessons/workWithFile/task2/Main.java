package lessons.workWithFile.task2;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path testFilePath = Paths.get("C:\\Users\\valeriy\\Documents\\Домашняя работа Stream.docx");

        Path fileName = testFilePath.getFileName();
        System.out.println(fileName);

        Path parent = testFilePath.getParent();
        System.out.println(parent);

        Path root = testFilePath.getRoot();
        System.out.println(root);

        boolean endWithTxt = testFilePath.endsWith("Documents\\Домашняя работа Stream.docx");
        System.out.println(endWithTxt);

        boolean startsWithLalala = testFilePath.startsWith("lalalala");
        System.out.println(startsWithLalala);

        System.out.println(testFilePath.isAbsolute());

        Path path5 = Paths.get("C:\\Users\\Java\\.\\examples");

        System.out.println(path5.normalize());

        Path path6 = Paths.get("C:\\Users\\Java\\..\\examples");
        System.out.println(path6.normalize());

        Path testFilePath1 = Paths.get("C:\\Users\\Users\\Users\\Users");
        Path testFilePath2 = Paths.get("C:\\Users\\Users\\Users\\Users\\Username\\Desktop\\testFile.txt");

        System.out.println(testFilePath1.relativize(testFilePath2));
    }
}
