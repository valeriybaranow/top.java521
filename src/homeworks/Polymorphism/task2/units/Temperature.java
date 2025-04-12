package homeworks.Polymorphism.task2.units;

import com.company.task2.units.Unit;

public interface Temperature extends Unit {
    default double convert(int meter) {
        return convertFromCelsius(meter);
    }
    double convertFromCelsius(int meter);
}
