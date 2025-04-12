package homeworks.Abstraction.task3;

public class Science extends Subject {
    public enum Type {
        NATURAL_SCIENCES,
        EXACT_SCIENCES,
        SOCIAL_HUMANITARIAN,
        FUNDAMENTAL_SCIENCES,
    }

    Type type;

    public Science(String name, String teacher, Type type) {
        super(name, teacher);
        this.type = type;
    }

    @Override
    public void study() {
        System.out.print(
                "Subject{" +
                        "name='" + name + '\'' +
                        ", teacher='" + teacher + '\'' +
                        ", type='" + type + '\'' + '}' + '\n'
        );
    }
}
