package week1.domain;

public class Vegetable implements Nameable {
    private final String name;

    public Vegetable(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
