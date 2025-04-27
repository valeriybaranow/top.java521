package lessons.ArrayList.Stack.StackFixed;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackFixed {
    final int CAPACITY = 10;
    int[] items = new int[CAPACITY];
    int index = -1;

    // помещение целого значения в стек
    public void push(int value) {
        if (!full()) {
            index++;
            items[index] = value;
        } else {
            throw new StackOverflowError();
        }
    }

    // выталкивание целого значения из стека,
    public int pop() {
        if (!empty()) {
            int temp = items[index];
            items[index] = 0;
            index--;
            return temp;
        }
        throw new EmptyStackException();
    }

    // подсчет количества целых в стеке,
    public int size() {
        return index + 1;
    }

    // проверку пустой ли стек,
    public boolean empty() {
        return index == - 1;
    }

    // проверку полный ли стек,
    public boolean full() {
        return index == CAPACITY - 1;
    }

    // очистку стека
    public void clear() {
        Arrays.fill(items, 0);
        index = -1;
    }

    // получение значения без выталкивания верхнего целого в стеке
    public int seek() {
        return items[index];
    }

    // вывести стек на экран
    public void printItems() {
        System.out.println(Arrays.toString(items));
    }
}
