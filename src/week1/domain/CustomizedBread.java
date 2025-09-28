package week1.domain;

import week1.view.BreadSize;

public class CustomizedBread extends Bread {
    private final BreadSize breadSize;
    private final boolean isToasted;

    public CustomizedBread(Bread bread, BreadSize breadSize, boolean isToasted) {
        super(bread.getName());
        this.breadSize = breadSize;
        this.isToasted = isToasted;
    }
    public int getBreadSizeValue() {
        return breadSize.getSizeValue();
    }
    public BreadSize getBreadSize() {
        return breadSize;
    }
    public boolean isToasted() {
        return isToasted;
    }
}
