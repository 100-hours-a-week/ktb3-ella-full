package week1.domain;

public class BreadCustom extends Bread{
    private final int breadSize;
    private final boolean isToasted;

    public BreadCustom(String name, int breadSize, boolean isToasted) {
        super(name);
        this.breadSize = breadSize;
        this.isToasted = isToasted;
    }
    public int getBreadSize() {
        return breadSize;
    }
    public boolean isToasted() {
        return isToasted;
    }
}
