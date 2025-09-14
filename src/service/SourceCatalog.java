package service;

import domain.Source;
import java.util.ArrayList;
import java.util.List;

public class SourceCatalog {
    List<Source> sources = new ArrayList<>();

    public SourceCatalog() {
        sources.add(new Source("랜치"));
        sources.add(new Source("마요네즈"));
        sources.add(new Source("스위트 어니언"));
        sources.add(new Source("허니 머스타드"));
        sources.add(new Source("스위트 칠리"));
        sources.add(new Source("핫 칠리"));
    }

    public int sourceCount(){
        return sources.size();
    }

    public Source getByNumber(int number){
        if (number < 1 || number > sources.size()) return null;
        return sources.get(number - 1);
    }

    public void displaySources(){
        System.out.println("\n--------------------소스 종류--------------------");
        for(int i=0; i<sources.size(); i++){
            Source source = sources.get(i);
            System.out.println((i+1)+"."+source.getName()+" ");
        }
        System.out.println("-------------------------------------------");
    }
}
