package homeworks.Sort;

public class Sort {
    public static void bubbleSort(int[] arrayNumbs) {
        for (int i = 0; i < arrayNumbs.length - 1; i++) {
            for (int j = 0; j < arrayNumbs.length - 1; j++) {
                if (arrayNumbs[j] > arrayNumbs[j + 1]) {
                    int temp = arrayNumbs[j];
                    arrayNumbs[j] = arrayNumbs[j + 1];
                    arrayNumbs[j + 1] = temp;
                }
            }
        }
    }


    public static void insertionSort(int[] arrayNumbs) {
        int temp;
        for (int i = 1; i < arrayNumbs.length; i++) {
            int k = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arrayNumbs[k] < arrayNumbs[j]) {
                    temp = arrayNumbs[k];
                    arrayNumbs[k--] = arrayNumbs[j];
                    arrayNumbs[j] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[] arrayNumbs) {
        int temp;
        for (int i = 0; i < arrayNumbs.length; i++) {
            for (int j = i + 1; j < arrayNumbs.length; j++) {
                if (arrayNumbs[i] > arrayNumbs[j]) {
                    temp = arrayNumbs[i];
                    arrayNumbs[i] = arrayNumbs[j];
                    arrayNumbs[j] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arrayNumbs) {
        int count = arrayNumbs.length;
        if (count < 2) {
            return;
        }
        int mid = count / 2;
        int[] leftArray = new int[mid];
        int[] rightAttay = new int[count - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = arrayNumbs[i];
        }
        for (int i = mid; i < count; i++) {
            rightAttay[i - mid] = arrayNumbs[i];
        }
        mergeSort(leftArray);
        mergeSort(rightAttay);

        merge(arrayNumbs, leftArray, rightAttay, mid, count - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            a[k++] = l[i] <= r[j] ? l[i++] : r[j++];
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}