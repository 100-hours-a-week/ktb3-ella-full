package week1.domain;

public class Product implements Nameable {
    private final String name;

    public Product (String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
