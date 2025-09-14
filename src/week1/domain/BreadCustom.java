package week1.domain;

public class BreadCustom {
    Bread bread;
    int breadSize;
    boolean isToasted;

    public BreadCustom(Bread bread, int breadSize, boolean isToasted) {
        this.bread = bread;
        this.breadSize = breadSize;
        this.isToasted = isToasted;
    }
    public int getBreadSize() {
        return breadSize;
    }
}
