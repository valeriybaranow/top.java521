package lessons.ArrayList.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/*
     Задание 2
     Измените стек из первого задания, таким образом, чтобы его размер был нефиксированным
 */
public class StackSimple {
    final int CAPACITY = 10;
    List<Integer> items = new ArrayList<>();
    int index = -1;

    // нажимать
    public void push(int value) {
        if (!full()) {
            items.add(value);
            index++;
        } else {
            throw new StackOverflowError();
        }
    }

    // выталкивать
    public Integer pop() {
        if (!empty()) {
            int temp = items.get(index);
            items.remove(index);
            index--;
            return temp;
        }
        throw new EmptyStackException();
    }

    // искать
    public Integer seek() {
        return items.get(index);
    }

    public boolean empty() {
        return index == -1;
    }

    public boolean full() {
        return index == CAPACITY - 1;
    }

    // TODO: заполнить нулями пустые значения стека
    public void clear() {
        items = new ArrayList<>();
        index = -1;
    }

    public void printItems() {
        System.out.println(items.toString());
    }
}
