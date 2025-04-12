package lessons.Abstraction.shape;

import java.awt.*;

public class Shape1 {
    private Color color;

    public Shape1(Color color) {
        this.color = color;
    }

    public double getArea() {
        return 1.2;
    } // абстрактный метод

    public void printInfo() {
        System.out.println(
                this +  "\n" +
                        "square " + getArea()
        );
    }
}
