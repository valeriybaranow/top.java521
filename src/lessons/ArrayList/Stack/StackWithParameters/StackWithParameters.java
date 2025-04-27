package lessons.ArrayList.Stack.StackWithParameters;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackWithParameters<T> {
    final int CAPACITY = 10;
    List<T> items = new ArrayList<>();
    int index = -1;

    // нажимать
    public void push(T value) {
        if (!full()) {
            items.add(value);
            index++;
        } else {
            throw new StackOverflowError();
        }
    }

    // выталкивать
    public T pop() {
        if (!empty()) {
            T temp = items.get(index);
            items.remove(items.get(index));
            index--;
            return temp;
        }
        throw new EmptyStackException();
    }

    // искать
    public int size() {
        return index + 1;
    }

    // искать
    public T seek() {
        return items.get(index);
    }

    public boolean empty() {
        return index == -1;
    }

    public boolean full() {
        return index == CAPACITY - 1;
    }

    public void clear() {
        items = new ArrayList<>();
        index = -1;
    }

    public void printItems() {
        System.out.println(items.toString());
    }
}
