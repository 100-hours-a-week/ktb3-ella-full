package week1.domain;

public class Addition implements Nameable, Priceable {
    private final String name;
    private final int price;

    public Addition(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getPrice(){
        return price;
    }
}
