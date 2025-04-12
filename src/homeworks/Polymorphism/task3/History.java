package homeworks.Polymorphism.task3;

public class History extends Subject {
    public enum Period {
        PRIMITIVE_SOCIETY,
        ANCIENT_WORLD,
        MIDDLE_AGES,
        NEW_TIMES,
        MODERN_TIMES,
    }
    Period period;

    public History(String name, String teacher, Period period) {
        super(name, teacher);
        this.period = period;
    }

    @Override
    public void study() {
        super.study();
        System.out.print(", period='" + period + '\'' + '}' + '\n');
    }
}
