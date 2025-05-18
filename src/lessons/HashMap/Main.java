package lessons.HashMap;


import java.util.*;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }

    public static void task1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        map.get("a");

        if(map.containsKey("b")) {
            map.remove("b");
        }
        map.clear();
        System.out.println(map.isEmpty());
        System.out.println(map.size());
        System.out.println(map.size());

        Set<String> set2 = map.keySet();
        Collection<Integer> set3 = map.values();

        var set4 = map.keySet();
        var set5 = map.values();
    }

    public static void task2() {
        HashMap<Person, String> map2 = new HashMap<>();
        map2.put(new Person("Farid", "Abdulaey", "888", "asfd@mail.ru"), "tel1");
        map2.put(new Person("Farid", "Abdulaey", "888", "asfd@mail.ru"), "tel1");
        map2.put(new Person("Farid", "Abdulaey", "888", "asfd@mail.ru"), "tel1");
        map2.put(new Person("Farid", "Abdulaey", "888", "asfd@mail.ru"), "tel1");

        for (Map.Entry<Person, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void task3() {
        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("dog", "sobaka");
        dictionary.put("brother", "brat");
        dictionary.put("mather", "mama");
        dictionary.put("father", "otec");

        do {
            System.out.println("Put word:");
            Scanner sc = new Scanner(System.in);
            String word = sc.nextLine().toLowerCase();

            if(dictionary.containsKey(word)) {
                System.out.println("en " + word + " " + dictionary.get(word));
            } else if (dictionary.containsValue(word)) {
                for (Map.Entry<String, String> entry: dictionary.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        System.out.println("en " +  entry.getKey()  + " " + entry.getValue());
                        break;
                    }
                }
            } else {
                System.out.println("Слово отсутствует");
            }
        } while (true);
    }

    public static void task4() {
        HashMap<String, List<String>> dictionary = new HashMap<>();
        dictionary.put("dog", List.of("sobaka"));
        dictionary.put("brother", List.of("brat"));
        dictionary.put("mather", List.of("mama"));
        dictionary.put("father", List.of("otec"));

        do {
            System.out.println("Put word:");
            Scanner sc = new Scanner(System.in);
            String word = sc.nextLine().toLowerCase();

            if(dictionary.containsKey(word)) {
                System.out.println("en " + word + " " + dictionary.get(word));
            } else if (dictionary.containsValue(word)) {
                for (Map.Entry<String,  List<String>> entry: dictionary.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        System.out.println("en " +  entry.getKey()  + " " + entry.getValue());
                        break;
                    }
                }
            } else {
                System.out.println("Слово отсутствует. Можете его добавить\n1 - Да\n2 - Нет");
                sc = new Scanner(System.in);
                int select = sc.nextInt();

                if (select == 1) {
                    System.out.println("Введите перевод слова");
                    sc = new Scanner(System.in);
                    String newWork = sc.nextLine().toLowerCase();
                    dictionary.put(newWork, List.of(word));
                }
            }
        } while (true);
    }
}
