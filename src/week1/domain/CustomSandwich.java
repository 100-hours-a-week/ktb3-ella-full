package week1.domain;


public class CustomSandwich extends CustomProduct {
    private final Sandwich sandwichMenu;
    private final CustomizedBread customizedBread;

    private static final int BREAD_SMALL_SIZE = 15;
    private static final int BREAD_LARGE_SIZE = 30;

    public CustomSandwich(Sandwich sandwichMenu, CustomizedBread customizedBread) {
        super(sandwichMenu.getName());
        this.sandwichMenu = sandwichMenu;
        this.customizedBread = customizedBread;
    }

    @Override
    public int getBasePrice() {
        if (customizedBread.getBreadSize() == BREAD_SMALL_SIZE) {
            return sandwichMenu.getPrice15cm();
        }
        return sandwichMenu.getPrice30cm();
    }

    @Override
    public int getPriceFor(Addition addition) {
        if (customizedBread.getBreadSize() == BREAD_LARGE_SIZE) {
            return addition.getPrice() * 2;
        }
        return addition.getPrice();
    }

    public CustomizedBread getCustomizedBread() {
        return customizedBread;
    }
}
