package week1.domain;

public class Bread implements Nameable {
    private final String name;

    public Bread(String name){
        this.name = name;
    }
    @Override
    public String getName(){
        return name;
    }
}
