package homeworks.Polymorphism.task2.units.temperature;

import com.company.task2.units.Temperature;

public class Fahrenheit implements Temperature {
    @Override
    public double convertFromCelsius(int tempetature) {
        return (double) tempetature*5/9;
    }
}
