package homeworks.Abstraction.task1;

public class VideoPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Проиграть видео");
    }

    @Override
    public void stop() {
        System.out.println("Остановить видео");
    }
}
