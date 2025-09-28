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
        BreadToaster breadToaster = new BreadToaster();

        ToastService toastService = new ToastService(breadToaster, outView);
        ProductCustomizer productCustomizer = new ProductCustomizer(
                cheeseCatalog, additionCatalog, sourceCatalog, vegetableCatalog
        );
        OrderService orderService = new OrderService(
                breadCatalog, cheeseCatalog, additionCatalog, sourceCatalog, vegetableCatalog,
                outView, inputView, productCatalog, productCustomizer, toastService
        );

        while (true) {
            orderService.startOrder();
            System.out.println("\n새 주문을 시작하려면 Enter를, 종료하려면 '종료'를 입력하세요.");
            if (inputView.getLine().equals("종료")) {
                break;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        toastService.shutdown();
    }
}