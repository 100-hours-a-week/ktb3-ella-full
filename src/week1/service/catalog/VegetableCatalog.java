package week1.service.catalog;

import week1.domain.Vegetable;

import java.util.List;

public class VegetableCatalog extends Catalog<Vegetable> {

    public VegetableCatalog() {
        super(List.of(
                new Vegetable("양상추"),
                new Vegetable("토마토"),
                new Vegetable("오이"),
                new Vegetable("피망"),
                new Vegetable("양파"),
                new Vegetable("올리브"),
                new Vegetable("할라피뇨")
        ));
    }

}
