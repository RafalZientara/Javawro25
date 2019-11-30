package pl.sda.rafal.zientara.game.lesson5.samples.optional;

public class Product {
    public final String name;
    public final double price;
    public final double weight;

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}
