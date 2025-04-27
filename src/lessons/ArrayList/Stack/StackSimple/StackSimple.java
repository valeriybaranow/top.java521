package lessons.ArrayList.Stack.StackSimple;

import java.util.ArrayList;
import java.util.List;

public class StackSimple {
    final int CAPACITY = 10;
    List<Integer> items = new ArrayList<>();
    int index = -1;

    // нажимать
    public void push(int value) throws Exception {
        if (!full()) {
            items.add(value);
            index++;
        } else {
            throw new Exception();
        }
    }

    // выталкивать
    public Integer pop() throws Exception {
        if (!empty()) {
            int temp = items.get(index);
            items.remove(index);
            index--;
            return temp;
        }
        throw new Exception();
    }

    // искать
    public Integer seek() {
        return items.get(index);
    }

    // искать
    public int size() {
        return index + 1;
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
