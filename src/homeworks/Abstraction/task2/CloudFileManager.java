package homeworks.Abstraction.task2;

public class CloudFileManager implements FileManager {
    @Override
    public void copyFile() {
        System.out.println("Копировать файл в облако");
    }

    @Override
    public void deleteFile() {
        System.out.println("Удалить файлы в облаке");
    }
}
