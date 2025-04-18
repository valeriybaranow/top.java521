package homeworks.Polymorphism.task2.units;

public interface Length extends Unit {
    default double convert(int meter) {
        return convertFromMeter(meter);
    }
    double convertFromMeter(int meter);
}
