package domain;

public class Salad extends CustomProduct{
    int price;

    public Salad(String name, int price) {
        super(name);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int calculatePrice() {
        int totalPrice = price;
        for(Addition addition:additions){
            totalPrice += addition.getPrice();
        }
        return totalPrice;
    }
}
