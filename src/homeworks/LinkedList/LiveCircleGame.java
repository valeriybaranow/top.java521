package homeworks.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Задача. “Слова/Города” (Живой круг)
 * Исправить все ошибки в коде, чтобы игра работала верно.
 * Игра в слова/города, люди называют слова по кругу, если человек <дальше вы придумываете условия, при которых люди будут выбывать по какой-то причине, пока не останется один человек – победитель>
 */
public class LiveCircleGame {
    public static void main(String[] args) {
        LinkedList<String> players = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        // Заполнение списка участников
        System.out.println("Введите имена участников игры (для завершения введите \"конец\"):");
        // TODO: добавлено значение по умолчанию
        String name = "";
        while (!name.equalsIgnoreCase("конец")) {
            // TODO: name перенесено внутрь из условия
            name = scanner.nextLine();
            // TODO: добавлено условие
            if (!name.equals("конец")) {
                players.add(name);
            }
        }

        // Игровой процесс
        System.out.println("Игра начинается!");
        String lastWord = "";

        // TODO: изменено условие
        while (players.size() > 1) {
            String currentPlayer = players.poll(); // Получаем текущего игрока и убираем его из списка - первый элемент из списка
            String inputWord;

            // Просим текущего игрока назвать слово, начинающееся с последней буквы предыдущего слова
            if (lastWord.isEmpty()) {
                System.out.println(currentPlayer + ", назовите слово: ");
            } else {
                System.out.println(currentPlayer + ", назовите слово, начинающееся с буквы \"" + lastWord.charAt(lastWord.length() - 1) + "\": ");
            }

            int count = 2;
            // Проверяем правильность введенного слова
            while (true) {
                inputWord = scanner.nextLine().toLowerCase();
                if (lastWord.isEmpty() || (lastWord.length() > 0 && inputWord.charAt(0) == lastWord.charAt(lastWord.length() - 1))) {
                    lastWord = inputWord; // Обновляем последнее слово
                    // Добавляем текущего игрока в конец списка
                    players.addLast(currentPlayer);
                    break;
                } else {
                    if (count == 0) {
                        System.out.println("Игрок " + currentPlayer + " выбыл из игры. Количество игроков " + players.size() + ".");
                        break;
                    } else {
                        System.out.println("Неверное слово! Количество попыток " + count-- + ". Попробуйте еще раз:");
                    }
                }
            }
        }

        // TODO: изменен вывод
        // Победитель
        System.out.println("Поздравляем, " + players.getFirst() + " Вы победитель в игре!");
    }
}
