package homeworks.Abstraction.task2;

public interface FileManager {
    void copyFile();
    void deleteFile();
    default void brake() {
        System.out.println("Тормоз!");
    }
}
