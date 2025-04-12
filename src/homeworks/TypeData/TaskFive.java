package homeworks.TypeData;

public class TaskFive {
    // TODO: Дано расстояние L в сантиметрах. Используя операцию деления нацело, найти количество полных метров в нем (1 метр = 100 см).
    public static void main(String[] args) {
        int L = 520;
        int Result = (L - L % 100)/100;
        System.out.println(Result);
    }
}