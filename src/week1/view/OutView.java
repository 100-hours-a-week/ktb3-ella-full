package week1.view;

import week1.domain.*;

import java.util.List;

public class OutView {

    public void WelcomeView(){
        System.out.println("어서오세요. 서브웨이 입니다!");
    }

    public <T extends Nameable> void printCatalog(List<T> items){
        System.out.println("\n--------------------종류--------------------");
        for(int i=0; i<items.size(); i++){
            T item = items.get(i);
            System.out.print((i+1)+". "+item.getName());
            if(item instanceof Priceable){
                System.out.print(" (+"+ ((Priceable) item).getPrice()+")");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }

    public void printMenu(List<Product> products){
        System.out.println("\n--------------------메뉴--------------------");
        for(int i=0; i<products.size(); i++) {
            Product product = products.get(i);
            System.out.print((i+1)+"."+ product.getName()+" ");
            if (product instanceof Sandwich sandwich) {
                System.out.printf("(15cm: %d원 | 30cm: %d원)\n", sandwich.getPrice15cm(), sandwich.getPrice30cm());
            } else if (product instanceof Salad salad) {
                System.out.printf("(%d원)\n", salad.getBasePrice());
            }
        }
        System.out.println("-------------------------------------------");
    }

    public void printOrderSummary(CustomProduct customProduct, Cheese cheese, List<Addition> additions,
                                  List<Vegetable> vegetables, List<Source> sources) {

        System.out.println("\n------------------ 영수증 ---------------------");

        System.out.printf("%s: %,d원\n", customProduct.getName(), customProduct.getBasePrice());

        if (customProduct instanceof CustomSandwich customSandwich) {
            CustomizedBread customizedBread = customSandwich.getCustomizedBread();
            String toastedStatus = customizedBread.isToasted() ? "구움" : "안 구움";
            System.out.printf("  - 빵: %s %dcm (%s)\n",
                    customizedBread.getName(),
                    customizedBread.getBreadSizeValue(),
                    toastedStatus);
        }
        System.out.println("  - 치즈: " + cheese.getName());

        if (!additions.isEmpty()) {
            System.out.println("  [추가 재료]");
            for (Addition addition : additions) {
                int price = customProduct.getPriceFor(addition);
                System.out.printf("  - %s (+%,d원)\n", addition.getName(), price);
            }
        }
        if (!vegetables.isEmpty()) {
            System.out.print("  - 제외한 야채: ");
            vegetables.forEach(v -> System.out.print(v.getName() + " "));
            System.out.println();
        }
        if (!sources.isEmpty()) {
            System.out.print("  - 선택 소스: ");
            sources.forEach(s -> System.out.print(s.getName() + " "));
            System.out.println();
        }

        System.out.println("-------------------------------------------");
        System.out.printf("최종 합계: %,d원\n", customProduct.calculatePrice());
        System.out.println("-------------------------------------------");
    }

    public void printBreadReadyMessage(String result) {
        System.out.println(result);
        System.out.println("[" + result + "] "+ "잠시만요, 빵 준비해드리겠습니다.");
    }

    public void printBreadToastError() {
        System.out.println("\n빵 조리 중 문제가 발생했습니다. 주문을 다시 시작해주세요.");
    }
}
