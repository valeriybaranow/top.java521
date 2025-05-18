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
    public static void main() {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(System.in);
        int select;
        do {
            System.out.println("""
                    Выберите действие: \
                    
                    1 - Найти слово\
                    
                    2 - Найти перевод\
                    
                    3 - Добавить слово\
                    
                    4 - Добавить перевод\
                    
                    5 - Редактировать слово\
                    
                    6 - Редактировать перевод\
                    
                    7 - Удалить слово из словаря\
                    
                    8 - Удалить вариант перевода слова\
                    
                    9 - Выход""");

            select = sc.nextInt();

            switch (select) {
                case 1:
                    dictionary.findWorld();
                    break;
                case 2:
                    dictionary.findTranslate();
                    break;
                case 3:
                    dictionary.addWord();
                    break;
                case 4:
                    dictionary.addTranslate();
                    break;
                case 5:
                    dictionary.editWord();
                    break;
                case 6:
                    dictionary.editTranslate();
                    break;
                case 7:
                    dictionary.deleteWord();
                    break;
                case 8:
                    dictionary.deleteTranslate();
                    break;
                case 9:
                    System.out.println("Пока!");
            }
//            clearConsole();
        } while (select != 9);
    }
}
