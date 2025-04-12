package homeworks.Polymorphism.task3;

public class Subject {
    String name;
    String teacher;

    public Subject(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void study() {
        System.out.print(
                "Subject{" +
                    "name='" + name + '\'' +
                    ", teacher='" + teacher + '\''
        );
    }
}
