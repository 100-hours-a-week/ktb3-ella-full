package week1.domain;

public class Cheese implements Nameable {
    private final String name;

    public Cheese(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}
