package homeworks.Polymorphism.task2.units;

public interface Temperature extends Unit {
    default double convert(int meter) {
        return convertFromCelsius(meter);
    }
    double convertFromCelsius(int meter);
}
