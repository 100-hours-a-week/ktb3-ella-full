package week1.service.catalog;

import week1.domain.Nameable;
import java.util.List;
import java.util.Optional;

public class Catalog<T extends Nameable> {
    private final List<T> items;

    public Catalog(List<T> items) {
        this.items = items;
    }

    public Optional<T> getByNumber(int number) {
        if(number < 1 || number > items.size()){ return Optional.empty(); }
        return Optional.of(items.get(number-1));
    }

    public int getCount() {
        return items.size();
    }

    public List<T> getItems() {
        return items;
    }
}
