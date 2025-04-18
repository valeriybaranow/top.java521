package lessons.Abstraction;


import lessons.Abstraction.home.HomeAppliance;
import lessons.Abstraction.home.RobotVacuum;
import lessons.Abstraction.home.SmartKettle;
import lessons.Abstraction.person.Person;
import lessons.Abstraction.shape.Rectagle;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Абстракция - это процесс скрытия деталей реализации и предоставления только общего представления объекта
        // Абстрактный класс - класс для наследования (может иметь абстрактные методы)
        // Интерфейс - абстрактный тип, определяющий контракт (набор методов), реализуемый в классах.
        // Статический метод у интерфейса не наследуется, а у класса наследуется

        // объект анонимного класса (от абстракции)
//        Shape shape = new Rectagle(Color.BLACK, 4, 3) {
//            public double getArea() {
//                return 0;
//            }
//        };
//        System.out.println(shape.getArea());

//        Circle circle = new Circle(Color.YELLOW, 521);
//        circle.printInfo();

        System.out.println();
        Rectagle rectagle = new Rectagle(Color.BLUE, 25, 10);
        rectagle.printInfo();


        /**
         * Анонимный класс — это класс без имени, который объявляется и создаётся одновременно в одном выражении. Он используется для:
         * Быстрой реализации интерфейсов
         * Переопределения методов класса/интерфейса
         * Создания одноразовых объектов
         * Основные особенности:
         * Не имеет имени (отсюда и название "анонимный")
         * Создается на лету при помощи оператора new
         * Может реализовывать интерфейс или наследовать класс
         * Не может иметь конструктор (так как у него нет имени)
         * Доступен только в месте создания
         */

        /**
         * Вложенные классы
         * статические
         * нестатические
         * локальные - внутри
         * анонимные
         */
        //
        // статические
        Person person = new Person(Person.Gender.FEMALE);
        person.speak(true);

        HomeAppliance kettle = new SmartKettle();
        HomeAppliance vacuum = new RobotVacuum();

        kettle.powerOn();
        kettle.powerOff();
        kettle.displayManufacturer();

        vacuum.powerOn();
        vacuum.powerOff();
        vacuum.displayManufacturer();
    }
}
