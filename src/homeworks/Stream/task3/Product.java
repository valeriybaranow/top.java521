package homeworks.Stream.task3;

public class Product {
    public String name;
    public int price;
    public String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "\n{" +
                "название: '" + name + '\'' +
                ", цена: " + price +
                ", категория: '" + category + '\'' +
                "";
    }
}
