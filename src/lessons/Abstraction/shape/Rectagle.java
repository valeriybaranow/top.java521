package lessons.Abstraction.shape;

import java.awt.*;

public class Rectagle extends Shape1 {
    private final double sideA;
    private final double sideB;


    public Rectagle(Color color, double sideA, double sideB) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
//                + this.getClass().getName()
                + " has sideA = " + sideA  + " has sideB = " + sideB;
    }
}
