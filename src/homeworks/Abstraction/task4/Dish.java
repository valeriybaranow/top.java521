package homeworks.Abstraction.task4;

public abstract class Dish {
    String name;
    String ingredients;
    double price;

    public Dish(String name, String ingredients, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    abstract void prepare();

    public void display() {
        System.out.print("" +
                "Блюдо{" +
                "name='" + name + '\'' +
                ", description='" + ingredients + '\'' +
                ", price=" + price + '\n'
        );
    }
}
