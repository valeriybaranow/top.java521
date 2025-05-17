package homeworks.HashMap;

import java.util.Scanner;

/*
    Реализовать CRUD operation
    C-reate    +
    R-ead      +
    U-pdate znaceniya
    U-pdate kluca
    D-elete po klucu
    D-elete po znaceniyu

    1)Реализовать удаление по ключу
    2)Реализовать удаление по значению
    3)Реализовать редактирование  значение
    4)Реализовать редактирование  ключа
 */

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("Выберите действие: " +
                    "\n1 - Найти перевод слова" +
                    "\n2 - Редактировать слово" +
                    "\n3 - Редактировать перевод" +
                    "\n4 - Удалить слово из словаря" +
                    "\n5 - Удалить вариант перевода слова" +
                    "\n6 - Выход");

            select = sc.nextInt();

            switch (select) {
                case 1:
                    dictionary.find();
                    break;
                case 2:
                    dictionary.editWord();
                    break;
                case 3:
                    dictionary.editTranslate();
                    break;
                case 4:
                    dictionary.deleteWord();
                    break;
                case 6:
                    System.out.println("Пока!");
                    continue;
            }

//            System.out.println("Put word:");
//
//            String word = sc.nextLine().toLowerCase();
//
//            if(dictionary.containsKey(word)) {
//                System.out.println("en " + word + " " + dictionary.get(word));
//            } else if (dictionary.containsValue(word)) {
//                for (Map.Entry<String,  List<String>> entry: dictionary.entrySet()) {
//                    if (entry.getValue().equals(word)) {
//                        System.out.println("en " +  entry.getKey()  + " " + entry.getValue());
//
//                        System.out.println("Продолжить\n1 - Продолжить\n2 - Редактировать");
//
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("Слово отсутствует. Можете его добавить\n1 - Да\n2 - Нет");
//                sc = new Scanner(System.in);
//                select = sc.nextInt();
//
//                if (select == 1) {
//                    System.out.println("Введите перевод слова");
//                    sc = new Scanner(System.in);
//                    String newWork = sc.nextLine().toLowerCase();
//                    dictionary.put(newWork, List.of(word));
//                }
//            }
        } while (select != 6);
    }
}
