package domain;

public class Sandwich extends CustomProduct{
    int price15cm;
    int price30cm;

    public Sandwich(String name, int price15cm, int price30cm) {
        super(name);
        this.price15cm = price15cm;
        this.price30cm = price30cm;
    }

    public int getPrice15cm() {
        return price15cm;
    }
    public int getPrice30cm() {
        return price30cm;
    }

    //TODO: 커스텀 가격 로직 추가
}
