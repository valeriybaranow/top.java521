package lessons.Abstraction.shape;

import java.awt.*;

public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract double getArea(); // абстрактный метод

    public void printInfo() {
        System.out.println(
            this +  "\n" +
            "square " + getArea()
        );
    }
}
