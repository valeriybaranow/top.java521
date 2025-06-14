package lessons.pattern.creation;

import java.util.ArrayList;
import java.util.List;

interface PizzaBuilder {
    void buildSouce();

    void buildDought();

    void buildChees();
}

class Pizza {
    String name;
    String dought;
    String south;
    String topping;

    public Pizza(String namet) {
        this.name = namet;
    }
}

class MargaritaPizzaBuilder implements PizzaBuilder {
    Pizza pizza;

    public MargaritaPizzaBuilder() {
        this.pizza = new Pizza("Vfhasdf");
    }

    @Override
    public void buildSouce() {

    }

    @Override
    public void buildDought() {

    }

    @Override
    public void buildChees() {

    }
}

class Director {
    List<PizzaBuilder> builderList;

    public Director(List<PizzaBuilder> builderList) {
        this.builderList = builderList;
    }

    public List<Pizza> getPizza() {
        return getPizzaDiff();
    }

    public List<Pizza> getPizzaDiff() {
        List<Pizza> list = new ArrayList<>();

        for (int i = 0; i < builderList.size(); i++) {
            builderList.get(i).buildSouce();
            builderList.get(i).buildDought();
            builderList.get(i).buildChees();
        }
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello word!");

        List<PizzaBuilder> list = new ArrayList<>();
        list.addAll(
                List.of(
                        new MargaritaPizzaBuilder()
                )
        );
        Director director = new Director(list);

        List<Pizza> pizza = director.getPizza();

        for (int i = 0; i < pizza.size(); i++) {
            System.out.println(pizza.get(i));
        }
    }
}
