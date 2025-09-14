package week1.service;

import week1.domain.Cheese;

import java.util.ArrayList;
import java.util.List;

public class CheeseCatalog {
    List<Cheese> cheeses = new ArrayList<>();
    public CheeseCatalog() {
        cheeses.add(new Cheese("아메리칸 치즈"));
        cheeses.add(new Cheese("슈레드 치즈"));
        cheeses.add(new Cheese("모짜렐라 치즈"));
    }

    public int getCheeseCount(){
        return cheeses.size();
    }

    public Cheese getByNumber(int number){
        if (number < 1 || number > cheeses.size()) return null;
        return cheeses.get(number - 1);
    }

    public void displayCheeses(){
        System.out.println("\n--------------------치즈 종류--------------------");
        for(int i=0; i<cheeses.size(); i++){
            Cheese cheese = cheeses.get(i);
            System.out.println((i+1)+"."+cheese.getName()+" ");
        }
        System.out.println("-------------------------------------------");
    }
}
