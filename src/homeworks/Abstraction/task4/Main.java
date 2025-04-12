package homeworks.Abstraction.task4;

/*
    Задача 4*: Ресторан
    1. Смоделируйте систему заказа блюд в ресторане с использованием абстрактного класса Dish.
    2. Создайте абстрактный класс Dish с общими характеристиками блюда (например, name, price, ingredients) и абстрактным методом prepare().
    3. Реализуйте подклассы, такие как Salad, Pasta, которые наследуются от Dish и предоставляют свои собственные реализации метода prepare() для приготовления каждого блюда.
    4. Создайте объекты различных блюд из меню ресторана и вызовите метод prepare() для каждого из них.
 */
public class Main {
    public static void main(String[] args) {
        Dish[] dishes = {
                new Salad("Салат", "ингридиенты", 100),
                new Pasta("Паста", "ингридиенты", 200),
        };

        for (int i = 0; i < dishes.length; i++) {
            dishes[i].prepare();
            dishes[i].display();
        }
    }
}
