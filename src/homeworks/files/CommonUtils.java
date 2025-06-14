package homeworks.files;

public class CommonUtils {

    public static Mode mode;

    private CommonUtils() {
        throw new UnsupportedOperationException("Это утилитарный класс, экземпляры создавать нельзя");
    }

    public static void checkMode(String[] args) {
        mode = (0 < args.length && null != args[0] && "-d".equals(args[0])) ? Mode.DEBUG : Mode.DEFAULT;
        showCheckMode();
    }

    public static void showCheckMode() {
        if (Mode.DEBUG == mode) {
            System.out.println("Включен режим тестирования");
        }
    }


    public static String pluralRu(int count, String one, String few, String many) {
        if (count % 10 == 1 && count % 100 != 11) {
            return one;
        } else if (count % 10 >= 2 && count % 10 <= 4 &&
                (count % 100 < 10 || count % 100 >= 20)) {
            return few;
        } else {
            return many;
        }
    }
}
