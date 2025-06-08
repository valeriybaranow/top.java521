package homeworks.files;

public class Functions {

    public static Mode mode;

    private Functions() {
    }

    public static void checkMode(String[] args) {
        mode = (0 < args.length && null != args[0] && "-d".equals(args[0])) ? Mode.DEBUG : Mode.DEFAULT;
        show();
    }

    public static void show() {
        if (Mode.DEBUG == mode) {
            System.out.println("Включен режим тестирования");
        }
    }
}
