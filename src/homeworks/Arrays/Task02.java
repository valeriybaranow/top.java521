package homeworks.Arrays;

import java.util.Arrays;

// TODO: Вам предоставляется массив элементов, и ваша задача - определить, есть ли дубликаты (повторяющиеся элементы) в массиве. Если есть, выведите информацию о том, какие элементы являются дубликатами и их индексы.
public class Task02 {
    public static void main(String[] args) {
        int[] numbers = {10, 2, 4, 10, 3, 3, 2, 10, 5, 6};
        System.out.println("Массив: " + Arrays.toString(numbers));
        // массив в котором храняться исключения для поиска, если число уже было найдено, то при его повторении поиск не будет повторяться
        boolean[] isExcludes = {false,false,false,false,false,false,false,false,false,false,false};
        for (int i = 0; i < numbers.length; i++) {
            if (isExcludes[i]) continue;
            // текущее число для поиска посторений в других элементах массива
            int currentNumber = numbers[i];
            // количество найденных повторений текущего числа
            int count = 0;
            // массив в котором храняться индексы повторений для текущего числа
            boolean[] indexes = new boolean[10];
            for (int j = 0; j < numbers.length; j++) {
                boolean isIncludes = currentNumber == numbers[j];
                if (isIncludes) {
                    if (i != j) isExcludes[j] = true;
                    count++;
                }
                indexes[j] = isIncludes;
            }
            if (count > 1) {
                System.out.print("Поторяется число " + currentNumber + " индекс ");
                for (int k = 0; k < indexes.length; k++) if (indexes[k]) System.out.print(" " + k);
                System.out.println();
            }
        }
    }
}

