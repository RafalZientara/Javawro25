package pl.sda.rafal.zientara.game.lesson5.samples.generic;

public class ProductModel extends ComparableModel  {

    public final String name;

    public ProductModel(long id, int size, String name) {
        super(id, size);
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }
}
