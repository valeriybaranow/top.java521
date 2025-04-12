package homeworks.TypeData;

public class TaskSix {
    // TODO: Даны целые положительные числа A и B (A>B). На отрезке длины A размещено максимально возможное количество отрезков длины B (без наложений). Используя операцию деления нацело, найти количество отрезков B, размещенных на отрезке A.
    public static void main(String[] args) {
        int A = 11;
        int B = 5;
        int Result = (A - A % B) / B;
        System.out.println(Result);
    }
}