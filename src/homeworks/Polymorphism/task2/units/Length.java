package homeworks.Polymorphism.task2.units;

import com.company.task2.units.Unit;

public interface Length extends Unit {
    default double convert(int meter) {
        return convertFromMeter(meter);
    }
    double convertFromMeter(int meter);
}
