package week1.service.catalog;

import week1.domain.Nameable;
import week1.domain.Priceable;

import java.util.List;

public class Catalog<T extends Nameable> {
    private final List<T> items;

    public Catalog(List<T> items) {
        this.items = items;
    }

    public T getByNumber(int number) {
        if(number < 1 || number > items.size()){ return null; }
        return items.get(number-1);
    }

    public int getCount() {
        return items.size();
    }

    public List<T> getItems() {
        return items;
    }
}
