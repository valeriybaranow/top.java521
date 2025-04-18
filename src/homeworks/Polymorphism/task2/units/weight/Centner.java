package homeworks.Polymorphism.task2.units.weight;

import homeworks.Polymorphism.task2.units.Weight;

public class Centner implements Weight {
    public double convertFromKilogram(int kilogram) {
        return (double) kilogram / 100;
    }
}
