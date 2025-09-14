package service;

import domain.Addition;

import java.util.ArrayList;
import java.util.List;

public class AdditionCatalog {
    List<Addition> additions = new ArrayList<>();
    public AdditionCatalog() {
        additions.add(new Addition("에그마요",1600));
        additions.add(new Addition("오믈렛",1600));
        additions.add(new Addition("아보카도",1600));
        additions.add(new Addition("베이컨",1600));
        additions.add(new Addition("페퍼로니",1600));
        additions.add(new Addition("치즈",1600));
        additions.add(new Addition("쉬림프 더블업",1600));
        additions.add(new Addition("주재료 2배",1600));
    }
    public int additionCount(){
        return additions.size();
    }

    public Addition getByNumber(int number){
        if (number < 1 || number > additions.size()) return null;
        return additions.get(number - 1);
    }

    public void displayAddition(){
        System.out.println("\n--------------------추가 재료 종류--------------------");
        for(int i=0; i<additions.size(); i++){
            Addition addition = additions.get(i);
            System.out.println((i+1)+"."+addition.getName()+" ");
        }
        System.out.println("-------------------------------------------");
    }
}
