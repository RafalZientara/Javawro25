package pl.sda.rafal.zientara.game.lesson5.samples.generic;

public class ComparableModel implements Comparable<ComparableModel>
        /*, Comparable<ProductModel>*/ {

    public final long id;
    public final int size;

    public ComparableModel(long id, int size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "ComparableModel{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }

    @Override
    public int compareTo(ComparableModel o) {
        return Integer.compare(this.size, o.size);
    }
/*
    @Override
    public int compareTo(ProductModel o) {
        return Integer.compare(this.size, o.size);
    }*/
}
