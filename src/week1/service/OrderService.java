package week1.service;

import week1.domain.*;
import week1.service.catalog.*;
import week1.view.InputView;
import week1.view.OutView;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class OrderService {

    private final InputView inputView;
    private final OutView outView;
    private  final BreadCatalog breadCatalog;
    private final CheeseCatalog cheeseCatalog;
    private final AdditionCatalog additionCatalog;
    private final SourceCatalog sourceCatalog;
    private final VegetableCatalog vegetableCatalog;
    private final ProductCatalog productCatalog;
    private final ProductCustomizer productCustomizer;
    private final BreadToaster breadToaster;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Future<String> breadToastJob;

    public OrderService(BreadCatalog breadCatalog, CheeseCatalog cheeseCatalog, AdditionCatalog additionCatalog,
                        SourceCatalog sourceCatalog, VegetableCatalog vegetableCatalog, OutView outView, InputView inputView,
                        ProductCatalog productCatalog, ProductCustomizer productCustomizer, BreadToaster breadToaster) {
        this.inputView = inputView;
        this.outView = outView;
        this.breadCatalog = breadCatalog;
        this.cheeseCatalog = cheeseCatalog;
        this.additionCatalog = additionCatalog;
        this.sourceCatalog = sourceCatalog;
        this.vegetableCatalog = vegetableCatalog;
        this.productCatalog = productCatalog;
        this.productCustomizer = productCustomizer;
        this.breadToaster = breadToaster;
    }

    public void startOrder() {
        outView.WelcomeView();
        CustomProduct customProduct = selectMainProduct();
        customizeProduct(customProduct);
    }

    private CustomProduct selectMainProduct() {
        outView.printMenu(productCatalog.getItems());
        int productNum = inputView.selectSingleOption("메뉴를 선택해주세요", productCatalog.getCount());
        return (CustomProduct) productCatalog.getByNumber(productNum);
    }

    private void customizeProduct(CustomProduct customProduct) {
        CustomizedBread customizedBread = customizeBreadFor(customProduct);
        Cheese cheese = customizeCheese();
        List<Addition> additions = customizeAdditions();
        List<Vegetable> vegetables = customizeVegetables();
        List<Source> sources = customizeSources();
        if (customProduct instanceof Sandwich) {
            ((Sandwich) customProduct).setBreadCustom(customizedBread);
        }
        additions.forEach(customProduct::addAddition);
        waitBreadToastIfNeeded();
        outView.printOrderSummary(customProduct, customizedBread, cheese, additions, vegetables, sources);
    }

    private CustomizedBread customizeBreadFor(CustomProduct product) {
        if (!(product instanceof Sandwich)) {
            return null;
        }
        outView.printCatalog(breadCatalog.getItems());
        int breadNum = inputView.selectSingleOption("빵을 선택해주세요", breadCatalog.getCount());
        Bread selectedBread = breadCatalog.getByNumber(breadNum);
        int breadSize = inputView.selectBreadSize();
        boolean isToasted = inputView.selectBreadToasted();
        breadToastJob = isToasted ? executorService.submit(breadToaster::breadToast) : null;
        return productCustomizer.customizeBread(selectedBread, breadSize, isToasted);
    }

    private Cheese customizeCheese() {
        outView.printCatalog(cheeseCatalog.getItems());
        int cheeseNum = inputView.selectSingleOption("치즈를 선택해주세요", cheeseCatalog.getCount());
        return productCustomizer.customizeCheese(cheeseNum);
    }

    private List<Addition> customizeAdditions() {
        outView.printCatalog(additionCatalog.getItems());
        List<Integer> additionNums = inputView.selectMultiOptions("추가할 재료를 선택해주세요. 30cm는 2배의 추가 비용이 발생합니다", additionCatalog.getCount());
        return productCustomizer.customizeAddition(additionNums);
    }

    private List<Vegetable> customizeVegetables() {
        outView.printCatalog(vegetableCatalog.getItems());
        List<Integer> vegetableNums = inputView.selectMultiOptions("제외할 야채를 선택해주세요", vegetableCatalog.getCount());
        return productCustomizer.customizeVegetable(vegetableNums);
    }

    private List<Source> customizeSources() {
        outView.printCatalog(sourceCatalog.getItems());
        List<Integer> sourceNums = inputView.selectMultiOptions("추가할 소스를 선택해주세요",  sourceCatalog.getCount());
        return productCustomizer.customizeSource(sourceNums);
    }

    private void waitBreadToastIfNeeded() {
        if (breadToastJob == null) {
            return;
        }
        try {
            String result = breadToastJob.get();
            outView.printBreadReadyMessage(result);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            outView.printBreadToastError();
        } catch (ExecutionException e) {
            outView.printBreadToastError();
        } finally {
            executorService.shutdown();
        }
    }

}