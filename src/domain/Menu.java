package domain;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Product> products = new ArrayList<>();

    public Menu(){
        products.add(new Sandwich("치킨 데리야끼", 7000, 12900));
        products.add(new Sandwich("스파이시 이탈리안", 6900, 12700));
        products.add(new Sandwich("치킨 베이컨 아보카도", 7900, 14700));
        products.add(new Sandwich("비엘티", 6600, 12200));
        products.add(new Sandwich("폴드포크 바베큐", 7200, 13300));
        products.add(new Sandwich("쉬림프", 7600, 14100));
        products.add(new Salad("베지 샐러드", 6700));
        products.add(new Salad("로스트 치킨 샐러드", 9100));
        products.add(new Salad("로티세리 바베큐 치킨 샐러드", 9100));
    }

    public void displayMenu() {
        System.out.println("\n--------------------메뉴--------------------");
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            System.out.print((i+1)+"."+ product.getName()+" ");
            if (product instanceof Sandwich sandwich) {
                System.out.printf("(15cm: %d원 | 30cm: %d원)\n", sandwich.getPrice15cm(), sandwich.getPrice30cm());
            } else if (product instanceof Salad salad) {
                System.out.printf("(%d원)\n", salad.getPrice());
            }
        }
        System.out.println("-------------------------------------------");
    }

    public int getMenuCount(){
        return products.size();
    }

    public Product getProductByNumber(int number) {
        if (number < 1 || number > products.size()) return null;
        return products.get(number - 1);
    }
}
