package week1.domain;

public class Sandwich extends Product {
    private final int price15cm;
    private final int price30cm;


    public Sandwich(String name, int price15cm, int price30cm) {
        super(name);
        this.price15cm = price15cm;
        this.price30cm = price30cm;
    }

    public int getPrice15cm() {
        return price15cm;
    }

    public int getPrice30cm() {
        return price30cm;
    }
}