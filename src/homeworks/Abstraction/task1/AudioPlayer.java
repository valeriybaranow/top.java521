package homeworks.Abstraction.task1;

public class AudioPlayer implements MediaPlayer {
    @Override
    public void play() {
        System.out.println("Проиграть аудио");
    }

    @Override
    public void stop() {
        System.out.println("Остановить аудио");
    }
}
