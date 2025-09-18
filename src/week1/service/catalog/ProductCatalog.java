package week1.service.catalog;

import week1.domain.Product;
import week1.domain.Salad;
import week1.domain.Sandwich;

import java.util.List;

public class ProductCatalog extends Catalog<Product> {

    public ProductCatalog(){
        super(List.of(
                new Sandwich("치킨 데리야끼", 7000, 12900),
                new Sandwich("스파이시 이탈리안", 6900, 12700),
                new Sandwich("치킨 베이컨 아보카도", 7900, 14700),
                new Sandwich("비엘티", 6600, 12200),
                new Sandwich("폴드포크 바베큐", 7200, 13300),
                new Sandwich("쉬림프", 7600, 14100),
                new Salad("베지 샐러드", 6700),
                new Salad("로스트 치킨 샐러드", 9100),
                new Salad("로티세리 바베큐 치킨 샐러드", 9100)
        ));
    }
}
