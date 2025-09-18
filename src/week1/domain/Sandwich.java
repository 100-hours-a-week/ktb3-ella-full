package week1.domain;

public class Sandwich extends CustomProduct {
    private final int price15cm;
    private final int price30cm;
    private CustomizedBread customizedBread;

    private final static int BREAD_SMALL_SIZE = 15;
    private final static int BREAD_LARGE_SIZE = 30;

    public Sandwich(String name, int price15cm, int price30cm) {
        super(name);
        this.price15cm = price15cm;
        this.price30cm = price30cm;
    }

    public void setBreadCustom(CustomizedBread customizedBread) {
        this.customizedBread = customizedBread;
    }

    public int getPrice15cm() {
        return price15cm;
    }

    public int getPrice30cm() {
        return price30cm;
    }

    @Override
    public int getBasePrice() {
        if (customizedBread == null) {
            return price15cm;
        }
        return (customizedBread.getBreadSize() == BREAD_SMALL_SIZE) ? price15cm : price30cm;
    }

    @Override
    public int getPriceFor(Addition addition) {
        if (customizedBread != null && customizedBread.getBreadSize() == BREAD_LARGE_SIZE) {
            return addition.getPrice() * 2;
        }
        return addition.getPrice();
    }
}