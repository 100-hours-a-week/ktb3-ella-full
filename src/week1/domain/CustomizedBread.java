package week1.domain;

public class CustomizedBread extends Bread {
    private final int breadSize;
    private final boolean isToasted;

    public CustomizedBread(Bread bread, int breadSize, boolean isToasted) {
        super(bread.getName());
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
