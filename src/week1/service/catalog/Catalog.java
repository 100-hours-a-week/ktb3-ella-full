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

    public void display() {
        System.out.println("\n--------------------종류--------------------");
        for(int i=0; i<items.size(); i++){
            System.out.print((i+1)+". "+items.get(i).getName());
            if(items instanceof Priceable){
                System.out.println(" (+"+ ((Priceable) items).getPrice()+")");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }
}
