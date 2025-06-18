package homeworks.regexp;

import java.util.regex.Pattern;

// TODO: разобраться в регулярными выпражениями
// https://javarush.com/groups/posts/regulyarnye-vyrazheniya-v-java

/**
 * 1. Метасимволы для поиска совпадений границ строк или текста
 * ^	начало строки
 * $	конец строки
 * \b	граница слова
 * \B	не граница слова
 * \A	начало ввода
 * \G	конец предыдущего совпадения
 * \Z	конец ввода
 * \z	конец ввода
 * <p>
 * 2. Метасимволы для поиска символьных классов
 * \d	цифровой символ
 * \D	нецифровой символ
 * \s	символ пробела
 * \S	непробельный символ
 * \w	буквенно-цифровой символ или знак подчёркивания
 * \W	любой символ, кроме буквенного, цифрового или знака подчёркивания
 * .	любой символ
 * <p>
 * 3. Метасимволы для поиска символов редактирования текста
 * \t	символ табуляции
 * \n	символ новой строки
 * \r	символ возврата каретки
 * \f	переход на новую страницу
 * \\u 0085	символ следующей строки
 * \\u 2028	символ разделения строк
 * \\u 2029	символ разделения абзацев
 * <p>
 * 4. Метасимволы для группировки символов
 * [абв]	любой из перечисленных (а,б, или в)
 * [^абв]	любой, кроме перечисленных (не а,б, в)
 * [a-zA-Z]	слияние диапазонов (латинские символы от a до z без учета регистра )
 * [a-d[m-p]]	объединение символов (от a до d и от m до p)
 * [a-z&&[def]]	пересечение символов (символы d,e,f)
 * [a-z&&[^bc]]	вычитание символов (символы a, d-z)
 * <p>
 * 5. Метасимволы для обозначения количества символов – квантификаторы. Квантификатор всегда следует после символа или группы символов.
 * ?	один или отсутствует
 * *	ноль или более раз
 * +	один или более раз
 * {n}	n раз
 * {n,}	n раз и более
 * {n,m}	не менее n раз и не более m раз
 */

public class Main {
    public static void main(String[] args) {

        // "А.+а" // жадный режим
        // "А.++а" // сверхжадный режим
        // "А.+?а" // ленивый режим

//        String text = "Егор Алла Александр";
//        System.out.println("жадный поиск в строке - " + text);
//        Pattern pattern1 = Pattern.compile("А.+а");
//        Matcher matcher = pattern1.matcher(text);
//        while (matcher.find()) {
//            System.out.println(text.substring(matcher.start(), matcher.end()));
//        }
//
//        System.out.println("сверхжадный поиск в строке - " + text);
//        Pattern pattern2 = Pattern.compile("А.++а");
//        Matcher matcher2 = pattern2.matcher(text);
//        while (matcher2.find()) {
//            System.out.println(text.substring(matcher2.start(), matcher2.end()));
//        }
//
//        System.out.println("ленивый поиск в строке - " + text);
//        Pattern pattern3 = Pattern.compile("А.+?а");
//        Matcher matcher3 = pattern3.matcher(text);
//        while (matcher3.find()) {
//            System.out.println(text.substring(matcher3.start(), matcher3.end()));
//        }
//
//        System.out.println("email");
//        String regex = "^[a-zA-Z0-9].[a-zA-Z0-9\\._%\\+\\-]{0,63}@[a-zA-Z0-9\\.\\-]+\\.[a-zA-Z]{2,30}$";
//        if (Pattern.matches(regex, "asdf@sdfa.ru")) {
//            System.out.println("yes");
//        }
//
//        long countInLine =
//                Pattern.compile("\\b[А-Яа-яA-Za-z]+\\b").matcher("фывафыва афыв слово").results().count();
//        System.out.println(countInLine);


        String text = "Java 17 — новый LTS-релиз (2021 год).";
        long wordCount = Pattern.compile("\\b[А-Яа-яA-Za-zЁё'0-9-]+\\b", Pattern.UNICODE_CHARACTER_CLASS).matcher(text).results().count();
        ; // Только слова (рус/англ)


        System.out.println("Количество слов: " + wordCount);
    }
}
