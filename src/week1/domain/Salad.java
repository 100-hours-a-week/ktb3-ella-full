package week1.domain;

public class Salad extends CustomProduct {
    private final int price;

    public Salad(String name, int price) {
        super(name);
        this.price = price;
    }

    @Override
    public int getBasePrice() {
        return price;
    }

    @Override
    public int getPriceFor(Addition addition) {
        return addition.getPrice();
    }

    @Override
    public String getMenuDescription() {
        return String.format("(%d원)", price);
    }
}
