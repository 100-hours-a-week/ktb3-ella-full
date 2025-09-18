package week1.service.catalog;

import week1.domain.Bread;

import java.util.List;

public class BreadCatalog extends Catalog<Bread> {

    public BreadCatalog() {
        super(List.of(
                new Bread("화이트"),
                new Bread("위트"),
                new Bread("플랫브레드"),
                new Bread("파마산 오레가노"),
                new Bread("허니오트"),
                new Bread("하티")
            ));
    }
}
