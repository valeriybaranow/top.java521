package lessons.Collection;

import java.util.ArrayList;
import java.util.List;

/*
     Задание 2.
     Измените стек из первого задания, таким образом, чтобы его размер был нефиксированным
 */
public class ListInt {
    List<Integer> items = new ArrayList<>();

    // нажимать
    public void add(int value) {
        items.add(value);
    }

    //
    public void remove(int index) {
        items.remove(index);
    }

    // показать
    public void printItems() {
        System.out.println(items.toString());
    }

    //
    public boolean contains(int value) {
        return items.contains(value);
    }

    public void stringToList(String str) {
        String[] listInt = str.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listInt.length; i++) {
            list.add(Integer.parseInt(listInt[i]));
        }
        items = new ArrayList<>(list);
    }

    // заменить
    public void set(int index, int value) {
        items.set(index, value);
    }
}
