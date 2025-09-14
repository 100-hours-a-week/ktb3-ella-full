package week1.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomProduct extends Product{

    List<Addition> additions = new ArrayList<>();

    public CustomProduct(String name) {
        super(name);
    }

    public void addAddition(Addition addition){
        this.additions.add(addition);
    }

    public abstract int calculatePrice();
}
