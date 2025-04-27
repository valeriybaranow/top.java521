package homeworks.Set;

import java.util.HashSet;

/*
Поиск пары чисел с заданной суммой:
    Дан массив целых чисел nums и целочисленное значение targetSum.
    Необходимо найти и вернуть индексы двух чисел в массиве, сумма которых равна targetSum.
    Предполагается, что в решении существует только одна пара чисел с заданной суммой.

Пример:
    plaintext
    Input: nums = [2, 7, 11, 15], targetSum = 9
    Output: [0, 1] (или [1, 0])

Подход к решению:
    Создайте пустой HashSet для хранения значений.
    Пройдите по каждому числу num в массиве nums.
    Для каждого числа num, проверьте, присутствует ли targetSum - num в HashSet:
    - Если да, то это означает, что найдена пара чисел с заданной суммой. Верните индексы текущего числа и числа targetSum - num.
    - Если нет, добавьте num в HashSet.
    Если после завершения прохода по массиву не найдена ни одна пара чисел, верните пустой массив или значение null.
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 13};
        int targetSum = 9;
        HashSet<Integer> numSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length && i != j; j++) {
                if (targetSum == (nums[i] + nums[j])) {
                    numSet.add(i);
                    numSet.add(j);
                }
            }
        }

        System.out.println(numSet);
    }
}
