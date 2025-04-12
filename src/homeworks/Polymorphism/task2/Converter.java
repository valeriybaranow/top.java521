package homeworks.Polymorphism.task2;

import com.company.task2.units.length.Centimeter;
import com.company.task2.units.length.Foot;
import com.company.task2.units.length.Millimeters;
import com.company.task2.units.temperature.Fahrenheit;
import com.company.task2.units.temperature.Kelvin;
import com.company.task2.units.weight.Centner;
import com.company.task2.units.weight.Tons;

/*
    Задача 2: Конвертер единиц
        1. Создайте класс Converter, который будет выполнять преобразования между различными единицами измерения с использованием статического полиморфизма.
        2. Реализуйте перегруженные статические методы для конвертации различных единиц измерения, например, convertLength(), convertTemperature(), convertWeight(). Каждый метод должен принимать соответствующие аргументы и возвращать результат конвертации.
        3. Обеспечьте различные варианты перегруженных методов для каждого типа конвертации, например, convertLength() может конвертировать длину из метров в футы, сантиметры или миллиметры, а также из других единиц измерения длины.
        4. Продемонстрируйте использование перегруженных методов Converter в main().
 */

public class Converter {
    public static void main(String[] args) {
        // длина
        System.out.println(convertLength(10, new Foot()));
        System.out.println(convertLength(10, new Centimeter()));
        System.out.println(convertLength(10, new Millimeters()));
        // температура
        System.out.println(convertTemperature(10, new Fahrenheit()));
        System.out.println(convertTemperature(10, new Kelvin()));
        // вес
        System.out.println(convertWeight(10, new Tons()));
        System.out.println(convertWeight(10, new Centner()));
    }

    public static double convertLength(int meter, Foot foot) {
        return foot.convert(meter);
    }

    public static double convertLength(int meter, Centimeter centimeter) {
        return centimeter.convert(meter);
    }

    public static double convertLength(int meter, Millimeters millimeters) {
        return millimeters.convert(meter);
    }

    public static double convertTemperature(int temperature, Fahrenheit fahrenheit)   {
        return fahrenheit.convert(temperature);
    }

    public static double convertTemperature(int temperature, Kelvin kelvin)   {
        return kelvin.convert(temperature);
    }

    public static double convertWeight(int kilogram, Tons tons)   {
        return tons.convert(kilogram);
    }

    public static double convertWeight(int kilogram, Centner centner)   {
        return centner.convert(kilogram);
    }
}
