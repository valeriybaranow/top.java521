package homeworks.Abstraction.task4;

public class Salad extends Dish {
    public Salad(String name, String ingredients, double price) {
        super(name, ingredients, price);
    }

    @Override
    void prepare() {
        System.out.println("Приготовление салата");
    }
}
