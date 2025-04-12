package homeworks.Abstraction.task3;

public abstract class Subject {
    String name;
    String teacher;

    public Subject(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public abstract void study();
}
