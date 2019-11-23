package pl.sda.rafal.zientara.game.lesson3.optional.model;

public class Toy {
    public final long id;
    public final String name;

    public Toy(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
