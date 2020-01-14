package Elements;

public class Meal {
    private String name;
    private int id;

    public Meal() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Meal(String name) {
    }
    @Override
    public String toString() {
        return name;
    }
}
