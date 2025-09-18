package week1.service.catalog;

import week1.domain.Cheese;

import java.util.List;

public class CheeseCatalog extends Catalog<Cheese> {

    public CheeseCatalog() {
        super(List.of(
                new Cheese("아메리칸 치즈"),
                new Cheese("슈레드 치즈"),
                new Cheese("모짜렐라 치즈")
        ));
    }
}
