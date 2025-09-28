package week1.service;


import week1.domain.*;
import week1.service.catalog.*;
import week1.view.BreadSize;

import java.util.List;
import java.util.stream.Collectors;

public class ProductCustomizer {


    private final CheeseCatalog cheeseCatalog;
    private final AdditionCatalog additionCatalog;
    private final SourceCatalog sourceCatalog;
    private final VegetableCatalog vegetableCatalog;

    public ProductCustomizer(CheeseCatalog cheeseCatalog, AdditionCatalog additionCatalog,
                             SourceCatalog sourceCatalog, VegetableCatalog vegetableCatalog) {
        this.cheeseCatalog = cheeseCatalog;
        this.additionCatalog = additionCatalog;
        this.sourceCatalog = sourceCatalog;
        this.vegetableCatalog = vegetableCatalog;
    }

    public CustomizedBread customizeBread(Bread bread, BreadSize breadSize, boolean isToasted) {
        return new CustomizedBread(bread, breadSize, isToasted);
    }

    public Cheese customizeCheese(int cheeseNum){
        return cheeseCatalog.getByNumber(cheeseNum)
                .orElseThrow((IllegalStateException::new));
    }

    public List<Addition> customizeAddition(List<Integer> additionNums){
        return additionNums.stream()
                .map(num -> additionCatalog.getByNumber(num)
                        .orElseThrow(() -> new IllegalArgumentException("선택한 추가 재료 번화가 유효하지 않습니다." + num)))
                .collect(Collectors.toList());
    }


    public List<Vegetable> customizeVegetable(List<Integer> vegetableNums) {
        return vegetableNums.stream()
                .map(num -> vegetableCatalog.getByNumber(num)
                        .orElseThrow(() -> new IllegalArgumentException("선택한 야채 번호가 유효하지 않습니다: " + num)))
                .collect(Collectors.toList());
    }

    public List<Source> customizeSource(List<Integer> sourceNums){
        return sourceNums.stream()
                .map(num -> sourceCatalog.getByNumber(num)
                        .orElseThrow(() -> new IllegalArgumentException("선택한 치즈 번호가 유효하지 않습니다: " + num)))
                .collect(Collectors.toList());
    }
}


