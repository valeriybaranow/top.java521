package homeworks.Stream.task1;


import homeworks.Stream.Gender;
import homeworks.Stream.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Создайте список объектов Person с полями name, age и gender.
 * Используя Stream, отфильтруйте только женщин старше 18 лет.
 * Соберите их имена в новый список.
 */
public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Gender gender = Generator.generateGender();
            persons.add(new Person(Generator.generateName(gender), Generator.generateAge(), gender));
        }
        persons.forEach(System.out::println);

        List<Person> personsNew = persons.stream()
                .filter(person -> person.getAge() > 18 && person.getGender() == Gender.FEMALE)
                .toList();

        System.out.println();
        System.out.println("Женщины старше 18 лет");
        personsNew.forEach(System.out::println);
    }
}
