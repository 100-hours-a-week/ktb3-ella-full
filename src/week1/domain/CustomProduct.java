package week1.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomProduct extends Product {
    protected final List<Addition> additions = new ArrayList<>();

    public CustomProduct(String name) {
        super(name);
    }

    public void addAddition(Addition addition) {
        this.additions.add(addition);
    }
    public abstract int getBasePrice();

    public abstract int getPriceFor(Addition addition);

    public int calculatePrice() {
        int totalPrice = getBasePrice();
        for (Addition addition : additions) {
            totalPrice += getPriceFor(addition);
        }
        return totalPrice;
    }
}
