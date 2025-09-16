package week1.domain;

public class Addition {
    private final String name;
    private final int price;

    public Addition(String name, int price){
        this.name = name;
        this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}
