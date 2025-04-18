package homeworks.Polymorphism.task2.units.length;


import homeworks.Polymorphism.task2.units.Length;

public class Millimeters implements Length {
    @Override
    public double convertFromMeter(int meter) {
        return 1000;
    }
}
