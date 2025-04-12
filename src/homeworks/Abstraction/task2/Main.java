package homeworks.Abstraction.task2;

import task1.AudioPlayer;
import task1.MediaPlayer;
import task1.VideoPlayer;

/*
    Задача 2*: Файловый менеджер
    1. Создайте интерфейс FileManager, который определяет методы для копирования и удаления файлов.
    2. Создайте интерфейс FileManager с методами copyFile() и deleteFile().
    3. Реализуйте классы LocalFileManager и CloudFileManager, которые реализуют интерфейс FileManager и предоставляют свои собственные реализации для копирования и удаления файлов на локальном устройстве и в облаке соответственно.
    4. Создайте объекты для управления файлами на локальном устройстве и в облаке, и выполните копирование и удаление файлов.
 */
public class Main {
    public static void main(String[] args) {
        FileManager[] fileManagers = {
                new LocalFileManager(),
                new CloudFileManager(),
        };

        for (int i = 0; i < fileManagers.length; i++) {
            fileManagers[i].copyFile();
            fileManagers[i].deleteFile();
        }
    }
}
