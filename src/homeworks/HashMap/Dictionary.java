package homeworks.HashMap;

import java.util.*;

public class Dictionary {
    public Map<String, List<String>> dictionary = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    int select = 0;

    public Dictionary() {
        dictionary.put("dog", List.of("собака", "пес"));
        dictionary.put("brother", List.of("брат"));
        dictionary.put("mather", List.of("мама"));
        dictionary.put("father", List.of("отец"));

        System.out.println("конструктор");

//        String w = "пес";
//        for (Map.Entry<String, List<String>> entryDictionary : dictionary.entrySet()) {
//            List<String> list = new ArrayList<>();
//            for(String str:  entryDictionary.getValue()) {
//                if (str.contains(w)) {
//                    list.add("test");
//                } else {
//                    list.add(str);
//                }
//            }
//            dictionary.replace(entryDictionary.getKey(), list);
//        }
//        System.out.println(dictionary);
    }

    public void find() {
        System.out.println("Введите слово:");
        String word = sc.nextLine().toLowerCase();
        if (dictionary.containsKey(word)) {
            System.out.println("Найдено слово en " + word + " " + dictionary.get(word));
        } else if (dictionary.containsValue(word)) {
            for (Map.Entry<String, List<String>> entryDictionary : dictionary.entrySet()) {
                for (String str : entryDictionary.getValue()) {
                    if (str.contains(word)) {
                        System.out.println("Найден перевод слова en " + word + " " + dictionary.get(word));
                        break;
                    }
                }
            }
        } else {
            add(word);
        }
    }

    public void add(String word) {
        System.out.println("Слово отсутствует. Можете его добавить\n1 - Да\n2 - Нет");
        sc = new Scanner(System.in);
        select = sc.nextInt();

        if (select == 1) {
            System.out.println("Введите перевод слова");
            sc = new Scanner(System.in);
            String newWork = sc.nextLine().toLowerCase();
            dictionary.put(newWork, List.of(word));
        }
    }

    public void editWord() {
        System.out.println("Введите слово которое нужно изменить:");
        String word = sc.nextLine().toLowerCase();
        if (dictionary.containsKey(word)) {
            System.out.println("Введите слово на которое нужно изменить");
            String wordReplace = sc.nextLine().toLowerCase();
            for (Map.Entry<String, List<String>> entryDictionary : dictionary.entrySet()) {
                if (entryDictionary.getKey().contains(word)) {
                    List<String> value = entryDictionary.getValue();
                    dictionary.remove(entryDictionary.getKey());
                    dictionary.put(wordReplace, value);
                    System.out.println("Слово " + word + " заменено на " + wordToString(wordReplace));
                    break;
                }
            }
        } else {
            System.out.println("Введенное слово не найдено");
        }
    }

    public void editTranslate() {
        System.out.println("Введите слово которое нужно изменить:");
        String word = sc.nextLine().toLowerCase();
        if (dictionary.containsKey(word)) {
            System.out.println("Введите перевод слова который нужно изменить");
            String translation = sc.nextLine().toLowerCase();
            String translationReplace = null;
            for (Map.Entry<String, List<String>> entryDictionary : dictionary.entrySet()) {
                if (entryDictionary.getKey().contains(word)) {
                    List<String> translationList = new ArrayList<>();
                    for (String str : entryDictionary.getValue()) {
                        if (str.contains(translation)) {
                            System.out.println("Введите перевод слова на который нужно изменить слово " + translation);
                            translationReplace = sc.nextLine().toLowerCase();
                            translationList.add(translationReplace);
                        } else {
                            translationList.add(str);
                        }
                    }
                    if (translationReplace != null) {
                        dictionary.remove(entryDictionary.getKey());
                        dictionary.put(word, translationList);
                        System.out.println("Перевод слова " + word + " " + translation + " был заменен  на " + translationReplace);
                    } else {
                        System.out.println("Перевод для слова " + word + " - " + translation + " не найден");
                    }
                    break;
                }
            }
        } else {
            System.out.println("Введенное слово не найдено");
        }
    }

    public void deleteWord() {
        System.out.println("Введите слово которое нужно изменить:");
        String word = sc.nextLine().toLowerCase();
        if (dictionary.containsKey(word)) {
            dictionary.remove(word);
            System.out.println("Введите слово на которое нужно изменить");
        } else {
            System.out.println("Введенное слово не найдено");
        }
    }

    private String wordToString(String word) {
        return word + " - варианты перевода: " + String.join(", ", dictionary.get(word));
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "dictionary=" + dictionary +
                '}';
    }
}
