package lessons.Exeption;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(1/0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch(Exception e2) {
            e2.printStackTrace();
        }

        try {
            // код, который может выбрасывать исключение или нет
            doSomething(-1);
            System.out.println(sum(5, 5));
        } catch (MyException  e1) { // сначала менее общие исключения - можно комбинировать типы
            System.err.println(e1.getCause());
            System.err.println("Поймали исключение: " + e1.getMessage());
        } catch (NullPointerException | ArrayIndexOutOfBoundsException  e1) { // сначала менее общие исключения - можно комбинировать типы
            System.out.println(e1.getMessage());
//            e1.printStackTrace(); // может работать дольше чем System.out.println и выводиться позже
//            System.out.println(e1.getCause());
        } catch (Exception e2) { // более общее исключение
            System.out.println(e2.getMessage());
        } finally { // работает всегда даже если есть return;
            System.out.println("finaly");
        }
        // далее код выполняется
        System.out.println("After");


        //  try-with-resources
        // Создатели Java и тут решили нам подсыпать немного синтаксического сахарку. Начиная с 7-й версии Java, в ней появился новый оператор try-with-resources (try с ресурсами).
        // создан как раз для того, чтобы решать проблему с обязательным вызовом метода close().
        //компилятор сам добавит секцию finally и вызов метода close()
        try(Scanner scanner = new Scanner(System.in))
        {
            scanner.useDelimiter("\n");
        }


    }

    public static void doSomething(int num) throws MyException {
        if (num < 0) {
            throw new MyException("Число не может быть меньше 0", new NullPointerException());
        }
    }

    public static int sum(int a, int b) {
        try {
            return a + b;
        } catch (RuntimeException e1) {
            System.out.println(e1.getMessage());
        } finally {
//            return a + a + b; // никода не делайте так, этот return будет в приоритете
        }
        return 0;
    }
}
