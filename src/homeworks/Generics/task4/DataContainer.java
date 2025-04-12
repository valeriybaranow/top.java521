package homeworks.Generics.task4;

import java.util.Arrays;

public class DataContainer <T extends Object> {

    private T[] container;

    public DataContainer(T[] container) {
        this.container = container;
    }

    // получение всех элементов
    public void print() {
        System.out.print("Содержимое контейнера ");
        for (T elem : container) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    // добавление элементов
    public void add(T item) {
        System.out.println("Добавление элемента " + item);
        T[] newArray = Arrays.copyOf(container, container.length + 1);
        container = newArray;
        container[container.length - 1] = item;
    }

    // получение элемента по индексу
    public T get(int index){
        System.out.println("Получение элемента по индексу " + index);
        return container[index];
    }

    // удаление элемента по индексу
    public void remove(int index){
        System.out.println("Удаление элемента по индексу " + index);
        if (index > container.length - 1) {
            return;
        }
        T[] newArray = Arrays.copyOf(container, container.length - 1);
        for (int i = 0; i < container.length; i++) {
            if (i > index) {
                newArray[i-1] = container[i];
            }
        }
        container = newArray;
    }

    //  поиск элемента
    public int find(T elem)
    {
        System.out.println("Поиск индекса элемента " + elem);
        for (int i = 0; i < container.length; i++) {
            if (container[i] == elem) {
                return i;
            }
        }
        return -1;
    }
}
