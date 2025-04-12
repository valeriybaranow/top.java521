package homeworks.Polymorphism.task2.units.weight;

import com.company.task2.units.Weight;

public class Tons implements Weight {
    public double convertFromKilogram(int kilogram) {
        return (double) kilogram / 1000;
    }
}
