package homeworks.Polymorphism.task2.units;

import com.company.task2.units.Unit;

public interface Weight extends Unit {
    default double convert(int kilogram) {
        return convertFromKilogram(kilogram);
    }
    double convertFromKilogram(int kilogram);
}
