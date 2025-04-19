package lessons.ArrayList.Stack;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
Задание 1
     Реализуйте класс стека для работы с целыми значениями (стек целых). Стек должен иметь фиксированный размер.
     Реализуйте набор операций для работы со стеком:
     ■ помещение целого значения в стек,
     ■ выталкивание целого значения из стека,
     ■ подсчет количества целых в стеке,
     ■ проверку пустой ли стек,
     ■ проверку полный ли стек,
     ■ очистку стека,
     ■ получение значения без выталкивания верхнего целого в стеке.
     При старте приложения нужно отобразить меню с помощью, которого пользователь может выбрать необходимую операцию
 */
public class StackFixed {
    final int CAPACITY = 10;
    int[] items = new int[CAPACITY];
    int index = -1;

    // нажимать
    public void push(int value) {
        if (!full()) {
            index++;
            items[index] = value;
        } else {
            throw new StackOverflowError();
        }
    }

    // выталкивать
    public int pop() {
        if (!empty()) {
            int temp = items[index];
            items[index] = 0;
            index--;
            return temp;
        }
        throw new EmptyStackException();
    }

    // искать
    public int seek() {
        return items[index];
    }

    public boolean empty() {
        return index == - 1;
    }

    public boolean full() {
        return index == CAPACITY - 1;
    }

    public void clear() {
        Arrays.fill(items, 0);
        index = -1;
    }

    public void printItems() {
        System.out.println(Arrays.toString(items));
    }
}
