package homeworks.Abstraction.task1;

import task1.AudioPlayer;
import task1.MediaPlayer;
import task1.VideoPlayer;

public class Main {

    /*
        Задача 1: Медиа-проигрыватель
        1. Создайте интерфейс MediaPlayer, который будет определять методы для проигрывания и остановки медиа-файлов.
        2. Создайте интерфейс MediaPlayer с методами play() и stop().
        3. Реализуйте классы AudioPlayer и VideoPlayer, которые реализуют интерфейс MediaPlayer и предоставляют собственные реализации методов play() и stop() для аудио и видео соответственно.
        4. Создайте объекты для проигрывания аудио и видео и вызовите методы play() и stop() для каждого из них.
     */
    public static void main(String[] args) {
        MediaPlayer[] mediaPlayers = {
                new AudioPlayer(),
                new VideoPlayer(),
        };

        for (int i = 0; i < mediaPlayers.length; i++) {
            mediaPlayers[i].play();
            mediaPlayers[i].stop();
        }
    }
}
