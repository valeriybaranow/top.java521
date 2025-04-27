package lessons.TreeSet;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task implements Comparable<Task> {
    private String name;
    private final LocalDateTime time;
    private boolean isDone;
    private static int equalsCounter = 0;

    public Task(String name) {
        this.time = LocalDateTime.now();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isDone() {
        return isDone;
    }

    public static int getEqualsCounter() {
        return equalsCounter;
    }

    @Override
    public boolean equals(Object o) {
        equalsCounter++;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isDone == task.isDone && Objects.equals(this.name.toLowerCase(), task.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), isDone);
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public int compareTo(Task task) {
        return this.getName().compareTo(task.getName());
    }
}
