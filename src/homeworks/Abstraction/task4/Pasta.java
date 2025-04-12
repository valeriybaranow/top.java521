package homeworks.Abstraction.task4;

public class Pasta extends Dish {
    public Pasta(String name, String ingredients, double price) {
        super(name, ingredients, price);
    }

    @Override
    void prepare() {
        System.out.println("Приготовление пасты");
    }
}
