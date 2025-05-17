package lessons.Classes;


import java.util.TreeMap;

public class Main {
    // Outer class - лежит на верхнем уровне, не вложен никуда
    // Nested class - лежит в другом классе
    //    static Nested class -
    //    static Nested class -
    // Local class - лежит в методе
    // Anonim class -
    // лямбда выражение функция

    // TreeMap - сначала сортирует, а потом добавляет - ключи не дублируются, вставка медленнее потому что сначала должен отсортировать

    public static void main(String[] args) {
//        OuterClass.InnerClass innerClass = new OuterClass.getInnerClass();
        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass();
        boolean admin = true;
        if (admin) {
            class MessageSender {
                public void send(String email) {
                    System.out.println(email);
                }
            }

            MessageSender messageSender = new MessageSender();
            messageSender.send("admin@gmail.com");

            MessageSender messageSender2 = new MessageSender() {
                public void send(String email) {
                    System.out.println(email);
                }
            };
        }
        Test test = new Test() {
            @Override
            void send() {
                super.send();
            }
        };

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        printArr(arr, x -> true);
        printArr(arr, x -> x % 2 == 0);
        printArr(arr, x -> x > 5);


        TreeMap<String, String> map = new TreeMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");

        TreeMap<String, String> map1 = new TreeMap<>();
        map1.put("key1", "value1");
        map1.put("key2", "value2");
        map1.put("key3", "value3");
        map1.put("key4", "value4");

        map.size();
        map.isEmpty();
        map.containsKey("key1");
        map.containsValue("value1");
        map.get("key2");
        map.remove("key2");
        map.firstEntry();
        map.firstKey();
        map.lastKey();
        map.lastEntry();
        map.putAll(map1);
        map.pollFirstEntry(); // удали и верни первую
        map.pollLastEntry(); // удали и верни последнюю
    }

//    MessageSender messageSender = str22 -> System.out.println("Farid");
//
//    Sum sum = (int x, int y) => x + y;

    public static void printArr(int[] arr, Filtrable filtrable) {
        for (int i = 0; i < arr.length; i++) {
            if (filtrable.check(i)) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();

    }

}

@FunctionalInterface
interface Filtrable {
    boolean check(int number);
}

interface Sum {
    int sum(int a, int b);
}

abstract class Test {
    void send() {
        System.out.println("send");
    }
}

interface MessageSender {
    void send();
}

class OuterClass {
    class InnerClass {

    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }

    static class StaticInnerClass {
        public StaticInnerClass() {

        }
    }
}
