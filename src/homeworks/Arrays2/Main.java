package homeworks.Arrays2;

import java.util.Arrays;

/*
   Есть 2 массива в отсортированные виде

   int[] arr = {-5,0,1,1,2,3,6,8,22,45,678}
   int[] arr2 = {-10,2,3,6,7,7,7,9,11,1000,1010,1100}

   int[] arr3 = { -10,-5,0,1,1,2,2,3,3,6,6,7,7,7,8,9,11,22,45,678,1000,1010,1100}

   Нельзя использовать сортировку
 */
public class Main {
    public static void main(String[] args) {
        int[] arr1 =  {-5,0,1,1,2,3,6,8,22,45,678};
        int[] arr2 = {-10,2,3,6,7,7,7,9,11,1000,1010,1100};
        int[] arr3 = merge(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] result = new int[len];
        int cursor1 = 0;
        int cursor2 = 0;
        for (int i = 0; i < len; i++) {
            result[i] = cursor1 >= arr1.length
                            ? arr2[cursor2++]
                            : cursor2 >= arr2.length
                                    ? arr1[cursor1++]
                                    : arr2[cursor2] <= arr1[cursor1] ? arr2[cursor2++] : arr1[cursor1++];
        }
        return result;
    }
}
