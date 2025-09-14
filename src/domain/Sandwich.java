package domain;

public class Sandwich extends CustomProduct{
    int price15cm;
    int price30cm;

    private int breadSize = 15;

    public Sandwich(String name, int price15cm, int price30cm) {
        super(name);
        this.price15cm = price15cm;
        this.price30cm = price30cm;
    }

    public void setBreadSize(int breadSize) {
        this.breadSize = breadSize;
    }
    public int getPrice15cm() {
        return price15cm;
    }
    public int getPrice30cm() {
        return price30cm;
    }

    @Override
    public int calculatePrice() {
        int totalPrice = (breadSize == 15) ? price15cm : price30cm;
        for(Addition addition:additions){
            totalPrice += (breadSize==15)? addition.getPrice(): addition.getPrice()*2;
        }
        return totalPrice;
    }
}
