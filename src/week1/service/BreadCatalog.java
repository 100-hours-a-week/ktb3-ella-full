package week1.service;

import week1.domain.Bread;

import java.util.ArrayList;
import java.util.List;

public class BreadCatalog {
    List<Bread> breads = new ArrayList<>();

    public BreadCatalog() {
        breads.add(new Bread("화이트"));
        breads.add(new Bread("위트"));
        breads.add(new Bread("플랫브레드"));
        breads.add(new Bread("파마산 오레가노"));
        breads.add(new Bread("허니오트"));
        breads.add(new Bread("하티"));
    }

    public int getBreadCount(){
        return breads.size();
    }
    public void displayBreads(){
        System.out.println("\n--------------------빵 종류--------------------");
        for(int i=0; i<breads.size(); i++){
            Bread bread = breads.get(i);
            System.out.println((i+1)+"."+bread.getName()+" ");
        }
        System.out.println("-------------------------------------------");
    }

    public Bread getByNumber(int number) {
        if (number < 1 || number > breads.size()) return null;
        return breads.get(number - 1);
    }
}
