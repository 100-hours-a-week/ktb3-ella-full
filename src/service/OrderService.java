package service;

import domain.*;
import view.Choose;

import java.util.List;

public class OrderService {
    Menu menu = new Menu();
    Choose choose = new Choose();
    BreadCatalog breadCatalog = new BreadCatalog();
    CheeseCatalog cheeseCatalog = new CheeseCatalog();
    AdditionCatalog additionCatalog = new AdditionCatalog();

    public void startOrder() {
        System.out.println("어서오세요 서브웨이 입니다!!");

        Product product = chooseMenu();

        if (product instanceof Sandwich sandwich) {
            BreadCustom breadCustom = chooseBread();
            Cheese cheese = chooseCheese();
            List<Addition> additions = chooseAdditions();

            sandwich.setBreadSize(breadCustom.getBreadSize());
            for(Addition addition : additions) {
                sandwich.addAddition(addition);
            }
            displayOrderSummary(sandwich, cheese, additions);

        } else if (product instanceof Salad salad) {
            Cheese cheese = chooseCheese();
            List<Addition> additions = chooseAdditions();
            for(Addition addition : additions) {
                salad.addAddition(addition);
            }
            displayOrderSummary(salad, cheese, additions);
        }
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
        List<Integer> numbers = choose.manyChoose("추가할 재료를 선택해주세요.", 1, additionCount);

        List<Addition> selectedAdditions = new java.util.ArrayList<>();
        for (int num : numbers) {
            selectedAdditions.add(additionCatalog.getByNumber(num));
        }
        return selectedAdditions;
    }
    private void displayOrderSummary(CustomProduct customProduct , Cheese cheese, List<Addition> additions) {
        System.out.println("\n--- 최종 주문 내역 ---");
        System.out.println("선택 메뉴: " + customProduct.getName());
        System.out.println("선택 치즈: " + cheese.getName());
        if (!additions.isEmpty()) {
            System.out.print("추가 재료: ");
            additions.forEach(a -> System.out.print(a.getName() + " "));
            System.out.println();
        }
        System.out.println("--------------------");
        System.out.println("최종 가격: " + customProduct.calculatePrice() + "원");
        System.out.println("--------------------");
    }
}
