package homeworks.Polymorphism.task2.units;


public interface Weight extends Unit {
    default double convert(int kilogram) {
        return convertFromKilogram(kilogram);
    }
    double convertFromKilogram(int kilogram);
}
