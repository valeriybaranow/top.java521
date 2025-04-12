package homeworks.Abstraction.task2;

public class LocalFileManager implements FileManager {
    @Override
    public void copyFile() {
        System.out.println("Копировать файл на локальном устройстве");
    }

    @Override
    public void deleteFile() {
        System.out.println("Удалить файл на локальном устройстве");
    }
}
