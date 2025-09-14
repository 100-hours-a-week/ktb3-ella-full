package service;

import domain.Addition;
import domain.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class VegetableCatalog {
    List<Vegetable> vegetables = new ArrayList<>();
    public VegetableCatalog() {
        vegetables.add(new Vegetable("양상추"));
        vegetables.add(new Vegetable("토마토"));
        vegetables.add(new Vegetable("오이"));
        vegetables.add(new Vegetable("피망"));
        vegetables.add(new Vegetable("양파"));
        vegetables.add(new Vegetable("피클"));
        vegetables.add(new Vegetable("올리브"));
        vegetables.add(new Vegetable("할라피뇨"));
    }
    public int vegetableCount(){
        return vegetables.size();
    }

    public Vegetable getByNumber(int number){
        if (number < 1 || number > vegetables.size()) return null;
        return vegetables.get(number - 1);
    }

    public void displayVegetables(){
        System.out.println("\n--------------------들어가는 기본 야채 재료 종류--------------------");
        for(int i=0; i<vegetables.size(); i++){
            Vegetable vegetable = vegetables.get(i);
            System.out.println((i+1)+"."+vegetable.getName()+" ");
        }
        System.out.println("-------------------------------------------");
    }
}
