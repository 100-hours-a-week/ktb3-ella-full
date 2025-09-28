package week1.domain;

public abstract class Product implements Nameable {
    private final String name;

    public Product (String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public abstract String getMenuDescription();
}
