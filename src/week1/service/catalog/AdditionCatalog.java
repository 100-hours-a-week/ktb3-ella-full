package week1.service.catalog;

import week1.domain.Addition;

import java.util.List;

public class AdditionCatalog extends Catalog<Addition> {

    public AdditionCatalog() {
        super(List.of(
                new Addition("에그마요",1600),
                new Addition("오믈렛",1200),
                new Addition("아보카도",1300),
                new Addition("베이컨",900),
                new Addition("페퍼로니",900),
                new Addition("치즈",900),
                new Addition("쉬림프 더블업",1800),
                new Addition("주재료 2배",1800)
        ));
    }
}
