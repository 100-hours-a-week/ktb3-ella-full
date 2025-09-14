package week1.service;

import week1.domain.*;
import week1.view.Choose;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    Menu menu = new Menu();
    Choose choose = new Choose();
    BreadCatalog breadCatalog = new BreadCatalog();
    CheeseCatalog cheeseCatalog = new CheeseCatalog();
    AdditionCatalog additionCatalog = new AdditionCatalog();
    VegetableCatalog  vegetableCatalog = new VegetableCatalog();
    SourceCatalog  sourceCatalog = new SourceCatalog();

    public void startOrder() {
        System.out.println("어서오세요 서브웨이 입니다!!");
        Product product = chooseMenu();
        BreadCustom breadCustom = null;

        if (product instanceof CustomProduct customProduct) {
            if (customProduct instanceof Sandwich sandwich) {
                breadCustom = chooseBread();
                sandwich.setBreadSize(breadCustom.getBreadSize());
            }
            customizeProduct(customProduct, breadCustom);
        }
    }

    private void customizeProduct(CustomProduct customProduct, BreadCustom breadCustom) {
        Cheese cheese = chooseCheese();
        List<Addition> additions = chooseAdditions();
        for (Addition addition : additions) {
            customProduct.addAddition(addition);
        }
        List<Vegetable> vegetables = chooseVegetables();
        List<Source> sources = chooseSources();

        displayOrderSummary(customProduct, breadCustom, cheese, additions, vegetables, sources);
    }

    public Product chooseMenu() {
        menu.displayMenu();
        int menuCount = menu.getMenuCount();
        int sel = choose.oneChoose("메뉴를 선택해주세요. ", 1, menuCount);
        return menu.getProductByNumber(sel);
    }

    public BreadCustom chooseBread() {
        breadCatalog.displayBreads();
        int breadCount = breadCatalog.getBreadCount();
        int breadNo = choose.oneChoose("빵을 선택해주세요 ", 1, breadCount);
        Bread selectedBread = breadCatalog.getByNumber(breadNo);
        int breadSize = (choose.oneChoose("빵 크기를 선택해주세요\n1.15cm  2.30cm ", 1,2)==1?15:30);
        boolean isToasted = (choose.oneChoose("빵 구워드릴까요?\n1.예   2.아니요", 1, 2) == 1);
        return new BreadCustom(selectedBread,breadSize,isToasted);
    }

    public Cheese chooseCheese(){
        cheeseCatalog.displayCheeses();
        int cheeseCount = cheeseCatalog.getCheeseCount();
        int cheeseNum = choose.oneChoose("치즈 선택해주세요\n",1, cheeseCount);
        return cheeseCatalog.getByNumber(cheeseNum);
    }

    private List<Addition> chooseAdditions() {
        additionCatalog.displayAddition();
        int additionCount = additionCatalog.additionCount();
        List<Integer> numbers = choose.manyChoose("추가할 재료를 선택해주세요. 30cm는 2배의 추가 비용이 발생합니다", 1, additionCount);

        List<Addition> selectedAdditions = new ArrayList<>();
        for (int num : numbers) {
            selectedAdditions.add(additionCatalog.getByNumber(num));
        }
        return selectedAdditions;
    }
    private List<Vegetable> chooseVegetables() {
        vegetableCatalog.displayVegetables();
        int vegetableCount = vegetableCatalog.vegetableCount();
        List<Integer> numbers = choose.manyChoose("제외할 야채를 선택해주세요", 1, vegetableCount);
        List<Vegetable> selectedVegetables = new ArrayList<>();
        for(int num : numbers){
            selectedVegetables.add(vegetableCatalog.getByNumber(num));
        }
        return selectedVegetables;
    }
    private List<Source> chooseSources() {
        sourceCatalog.displaySources();
        int sourceCount = sourceCatalog.sourceCount();
        List<Integer> numbers = choose.manyChoose("추가할 소스를 선택해주세요", 1, sourceCount);
        List<Source> selectedSources = new ArrayList<>();
        for(int num : numbers){
            selectedSources.add(sourceCatalog.getByNumber(num));
        }
        return selectedSources;
    }
    private void displayOrderSummary(CustomProduct customProduct, BreadCustom breadCustom, Cheese cheese, List<Addition> additions,
                                     List<Vegetable> vegetables, List<Source> sources) {
        System.out.println("\n------------------영수증---------------------");

        int basePrice = 0;
        if (customProduct instanceof Sandwich sandwich) {
            basePrice = (sandwich.getBreadSize() == 15) ? sandwich.getPrice15cm() : sandwich.getPrice30cm();
        } else if (customProduct instanceof Salad salad) {
            basePrice = salad.getPrice();
        }
        System.out.println(customProduct.getName() + ": " + basePrice + "원");

        if (customProduct instanceof Sandwich && breadCustom != null) {
            String toastedStatus = breadCustom.isToasted() ? "구움" : "안 구움";
            System.out.printf("  - 빵: %s %dcm (%s)\n",
                    breadCustom.getBread().getName(),
                    breadCustom.getBreadSize(),
                    toastedStatus);
        }
        System.out.println("  - 치즈: " + cheese.getName());
        if (!additions.isEmpty()) {
            System.out.println("추가 재료:");
            for (Addition addition : additions) {
                int additionPrice = addition.getPrice();
                if (customProduct instanceof Sandwich sandwich && sandwich.getBreadSize() == 30) {
                    additionPrice *= 2;
                }
                System.out.println("  - " + addition.getName() + " (+" + additionPrice + "원)");
            }
        }
        if (!vegetables.isEmpty()) {
            System.out.print("제외한 야채: ");
            vegetables.forEach(a -> System.out.print(a.getName() + " "));
            System.out.println();
        }
        if (!sources.isEmpty()) {
            System.out.print("선택 소스: ");
            sources.forEach(a -> System.out.print(a.getName() + " "));
            System.out.println();
        }
        System.out.println("------------------------------------------");
        System.out.println("최종 가격: " + customProduct.calculatePrice() + "원");
        System.out.println("------------------------------------------");
    }
}