import domain.*;

public class SubwayCli {
    Menu menu = new Menu();
    Choose choose = new Choose();
    BreadCatalog breadCatalog = new BreadCatalog();
    CheeseCatalog cheeseCatalog = new CheeseCatalog();

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
        int breadSize = choose.oneChoose("빵 크기를 선택해주세요\n1.15cm  2.30cm ", 1,2);
        boolean isToasted = (choose.oneChoose("빵 구워드릴까요?\n1.예   2.아니요", 1, 2) == 1);
        return new BreadCustom(selectedBread,breadSize,isToasted);
    }

    public Cheese chooseCheese(){
        cheeseCatalog.displayBreads();
        int cheeseCount = cheeseCatalog.getCheeseCount();
        int cheeseNum = choose.oneChoose("치즈 선택해주세요\n",1, cheeseCount);
        return cheeseCatalog.getByNumber(cheeseNum);
    }
    public static void main(String[] args) {
        SubwayCli subwayCli = new SubwayCli();
        System.out.println("어서오세요 서브웨이 입니다!!");
        Product product = subwayCli.chooseMenu();
        if(product instanceof Sandwich){
            BreadCustom breadCustom = subwayCli.chooseBread();
        }
        Cheese cheese = subwayCli.chooseCheese();

    }
}