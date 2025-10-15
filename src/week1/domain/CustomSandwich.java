package week1.domain;


import week1.view.BreadSize;

public class CustomSandwich extends CustomProduct {
    private final Sandwich sandwichMenu;
    private final CustomizedBread customizedBread;

    public CustomSandwich(Sandwich sandwichMenu, CustomizedBread customizedBread) {
        super(sandwichMenu.getName());
        this.sandwichMenu = sandwichMenu;
        this.customizedBread = customizedBread;
    }

    @Override
    public int getBasePrice() {
        if (customizedBread.getBreadSize() == BreadSize.SIZE_15) {
            return sandwichMenu.getPrice15cm();
        }
        return sandwichMenu.getPrice30cm();
    }

    @Override
    public int getPriceFor(Addition addition) {
        if (customizedBread.getBreadSize() == BreadSize.SIZE_30) {
            return addition.getPrice()*2;
        }
        return addition.getPrice();
    }

    public CustomizedBread getCustomizedBread() {
        return customizedBread;
    }

    @Override
    public String getMenuDescription() {
        return sandwichMenu.getMenuDescription();
    }
}
