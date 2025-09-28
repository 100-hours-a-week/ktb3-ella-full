package week1.service;


import week1.domain.*;
import week1.service.catalog.*;
import week1.view.BreadSize;

import java.util.ArrayList;
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
        return cheeseCatalog.getByNumber(cheeseNum);
    }

    public List<Addition> customizeAddition(List<Integer> additionNums){
        return additionNums.stream()
                .map(additionCatalog::getByNumber)
                .collect(Collectors.toList());
    }

    public List<Vegetable> customizeVegetable(List<Integer> vegetableNums){
        List<Vegetable> selectedVegetables = new ArrayList<>();
        for(int num : vegetableNums){
            selectedVegetables.add(vegetableCatalog.getByNumber(num));
        }
        return selectedVegetables;
    }

    public List<Source> customizeSource(List<Integer> sourceNums){
        List<Source> selectedSources = new ArrayList<>();
        for(int num : sourceNums){
            selectedSources.add(sourceCatalog.getByNumber(num));
        }
        return selectedSources;
    }
}


