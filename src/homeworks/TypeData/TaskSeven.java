package homeworks.TypeData;

public class TaskSeven {
    // TODO: Дано целое число A. Проверить истинность высказывания: «Число A является положительным».
    public static void main(String[] args) {
        int A = 11;
        if (A > 0) {
            System.out.println(String.format("Да. Число %d положительное.", A));
        } else {
            System.out.println(String.format("Нет. Число %d не положительное.", A));
        }
    }
}