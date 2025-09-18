package week1;

import week1.service.*;
import week1.service.catalog.*;
import week1.view.InputView;
import week1.view.OutView;

public class SubwayCli {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutView outView = new OutView();
        BreadCatalog breadCatalog = new BreadCatalog();
        CheeseCatalog cheeseCatalog = new CheeseCatalog();
        ProductCatalog productCatalog = new ProductCatalog();
        VegetableCatalog vegetableCatalog = new VegetableCatalog();
        SourceCatalog sourceCatalog = new SourceCatalog();
        AdditionCatalog additionCatalog = new AdditionCatalog();

        ProductCustomizer productCustomizer = new ProductCustomizer(
                cheeseCatalog, additionCatalog, sourceCatalog, vegetableCatalog
        );
        OrderService orderService = new OrderService(
                breadCatalog, cheeseCatalog, additionCatalog, sourceCatalog, vegetableCatalog,
                outView, inputView, productCatalog, productCustomizer
        );

        orderService.startOrder();
    }
}