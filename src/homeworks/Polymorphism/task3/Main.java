package homeworks.Polymorphism.task3;

public class Main {
    public static void main(String[] args) {
        Subject[] subjects = {
                new History("История", "Зорина Валентина Перровна", History.Period.NEW_TIMES),
                new Math("Математика", "Маина Петровна", Math.Type.ALGEBRA),
                new Math("Математика", "Маина Петровна", Math.Type.GEOMETRY),
                new Science("Науки", "Зоя Павловна", Science.Type.NATURAL_SCIENCES),
        };

        for (int i = 0; i < subjects.length; i++) {
            subjects[i].study();
        }
    }
}
