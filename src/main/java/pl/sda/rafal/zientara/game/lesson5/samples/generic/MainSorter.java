package pl.sda.rafal.zientara.game.lesson5.samples.generic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainSorter {

    public static void main(String[] args) {
        //todo poka to ludziom
        List<ProductModel> products = Arrays.asList(
                new ProductModel(4, 5, "5"),
                new ProductModel(1, 2, "3"),
                new ProductModel(6, 7, "8")
        );
        sortSuper(products);
//        sortExtends(products);//nie mozna - ProductModel musialoby implementowac Comparable<ProductModel>
        // lub ComparableModel musialby implementowac Comparable<ProductModel> co jest bardzo dziwnym podejsciem
//        sortSimple(products);//tutaj ProductModel musialby implementowac Comparator<ProductModel>
        System.out.println(products);


        List<ComparableModel> models = Arrays.asList(
                new ComparableModel(4, 5),
                new ComparableModel(1, 2),
                new ComparableModel(6, 7)
        );
        sortSuper(models);
        sortExtends(models);
        sortSimple(models);
        System.out.println(products);
    }

    public static <T extends Comparable<? super T>> void sortSuper(List<T> list) {
        //wymagania: jak mamy klase B dziedziczaca po A,
        //to wystarczy ze przekazujac B, tylko A implementuje comparable<A>
        Collections.sort(list);
    }

    public static <T extends Comparable<? extends T>> void sortExtends(List<T> list) {
//        Collections.sort(list); //tak nie zadziala

        //ale mozna metode sprawdzic jak zadziala z ComparableModel i z ProductModel :D
    }

    public static <T extends Comparable<T>> void sortSimple(List<T> list) {
        Collections.sort(list);
    }

}
