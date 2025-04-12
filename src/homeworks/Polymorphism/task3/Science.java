package homeworks.Polymorphism.task3;

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
        super.study();
        System.out.print(", type='" + type + '\'' + '}' + '\n');
    }
}
