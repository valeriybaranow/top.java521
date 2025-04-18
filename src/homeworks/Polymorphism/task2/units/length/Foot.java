package homeworks.Polymorphism.task2.units.length;

import homeworks.Polymorphism.task2.units.Length;

public class Foot implements Length {
    public double convertFromMeter(int meter) {
        return meter * 3.2808333333465;
    }
}
