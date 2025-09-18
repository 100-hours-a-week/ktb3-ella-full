package week1.service.catalog;

import week1.domain.Source;

import java.util.List;

public class SourceCatalog extends Catalog<Source> {

    public SourceCatalog() {
        super(List.of(
                new Source("랜치"),
                new Source("마요네즈"),
                new Source("스위트 어니언"),
                new Source("허니 머스타드"),
                new Source("스위트 칠리"),
                new Source("핫 칠리")
        ));
    }
}
