package homeworks.Polymorphism.task4;

public class Dessert extends MenuItem {
    String type;

    public Dessert(String name, String description, double price, String type) {
        super(name, description, price);
        this.type = type;
    }

    @Override
    public void display() {
        super.display();
        System.out.print( ", type=" + type + '\n');
    }
}
