package homeworks.Arrays;

// TODO: У вас есть массив строк, и ваша задача - найти самую длинную строку в этом массиве.
public class Task07 {
    public static void main(String[] args) {
        String[] str = {
                "Лиса",
                "Волк и заяч",
                "Крыса",
        };
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].length() > str[index].length()) {
                index = i;
            }
        }
        System.out.println("Самая длинная строка: " + str[index]);
    }
}
