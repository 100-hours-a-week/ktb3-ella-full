package week1.domain;

public class Source implements Nameable {
    private final String name;

    public Source(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
