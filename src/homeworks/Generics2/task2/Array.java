package homeworks.Generics2.task2;

import java.util.*;

public class Array<T extends Comparable<T>> {
    // TODO: тут интересно попробовать с чистым массивом
    private final AbstractList<T> array = new ArrayList<>();

    public void add(T item) {
        array.add(item);
    }

    public T max() {
        if (array.isEmpty()) {
            return null;
        }
        T max = array.getFirst();
        for (T val : array) {
            if (val.compareTo(max) > 0) {
                max = val;
            }
        }
        return max;
    }

    public T min() {
        if (array.isEmpty()) {
            return null;
        }
        T min = array.getFirst();
        for (T val : array) {
            if (val.compareTo(min) < 0) {
                min = val;
            }
        }
        return min;
    }

    public T average() {
        if (array.isEmpty()) {
            return null;
        }
        if (array.getFirst() instanceof Number) {
            Double sum = 0.0;
            for (T val : array) {
                sum += ((Number) val).doubleValue();
            }
            Double average = sum / array.size();
            return (T) average;
        } else {
            StringBuffer sb = new StringBuffer();
            int i = 0;
            for (T val : array) {
                sb.append(val.toString());
                if (array.size() -1 != i) {
                    sb.append(" + ");
                }
                i++;
            }
            sb.append("/" + array.size());
            return (T) sb.toString();
        }
    }

    public void sortAsc() {
        Collections.sort(array, Comparator.naturalOrder());
    }

    public void sortDesc() {
        Collections.sort(array, Comparator.reverseOrder());
    }

    public int find(T item) {
        int min = 0;
        int max = array.size()-1;
        while (max >= min) {
            int middle = min + (max-min)/2;
            if (array.get(middle) == item) {
                return middle;
            } else if (array.get(middle).compareTo(item) > 0) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return -1;
    }

    public void replase(T item, int index) {
        array.set(index, item);
    }

    @Override 
    public String toString() {
        return array.toString();
    }
}
