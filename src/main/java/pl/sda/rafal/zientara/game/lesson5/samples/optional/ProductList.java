package pl.sda.rafal.zientara.game.lesson5.samples.optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ProductList {

    public static void main(String[] args) {
        List<Product> elements = Arrays.asList(new Product("Milka", 3.50, 0.31),
                new Product("Kinder", 3.70, 0.3),
                new Product("Alpen Gold", 2.50, 0.35));
        Optional<Double> min1 = elements.stream()
                .map(product -> product.price)
                .min(Comparator.comparingDouble(o -> o));
        //todo 1 Cena najtanszej czekolady
        System.out.println(min1);

        //todo 2 najtanszy obiekt Product
        Optional<Product> min2 = elements.stream()
                .min(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return Double.compare(o1.price, o2.price);
                    }
                });
        System.out.println(min2);

    }
}
