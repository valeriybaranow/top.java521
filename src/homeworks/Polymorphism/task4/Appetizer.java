package homeworks.Polymorphism.task4;

public class Appetizer extends MenuItem {
    int size;

    public Appetizer(String name, String description, double price, int size) {
        super(name, description, price);
        this.size = size;
    }

    @Override
    public void display() {
        super.display();
        System.out.print( ", size=" + size + '\n');
    }
}
