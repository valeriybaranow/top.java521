package homeworks.Generics.task4;

/**
     Задача 4*: Контейнер для хранения и работы с разными типами данных
     Напишите обобщенный (шаблонный) класс DataContainer, который представляет контейнер для хранения элементов разных типов данных.   Этот контейнер должен поддерживать добавление элементов, получение элемента по индексу, удаление элемента по индексу, поиск элемента в контейнере и получение всех элементов.
 */

public class Main {
    public static void main(String[] args) {
        Integer[] arrInt = {1,2,3,4,5};
        DataContainer<Integer> dataContainer = new DataContainer<>(arrInt);
        dataContainer.print();
        dataContainer.add(6);
        dataContainer.print();
        int indexInt = dataContainer.find(4);
        if (indexInt == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println(indexInt);
        }
        System.out.println(dataContainer.get(1));
        dataContainer.remove(3);
        dataContainer.print();

        String[] arrStr = {"maybe", "I", "maybe", "you"};
        DataContainer<String> dataContainer1 = new DataContainer<>(arrStr);
        dataContainer1.print();
        dataContainer1.add("can");
        dataContainer1.add("make");
        dataContainer1.add("a change");
        dataContainer1.print();
        int indexStr = dataContainer1.find("make");
        if (indexStr == -1) {
            System.out.println("Элемент не найден");
        } else {
            System.out.println(indexStr);
        }
        System.out.println(dataContainer1.get(1));
        dataContainer1.remove(4);
        dataContainer1.print();
    }
}
