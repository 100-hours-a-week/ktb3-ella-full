import domain.Choose;
import domain.Menu;

public class SubwayCli {
    Menu menu = new Menu();
    Choose choose = new Choose();

    public void chooseMenu() {
        menu.displayMenu();
        int menuCount = menu.getMenuCount();
        choose.oneChoose("메뉴를 선택해주세요.  ",1, menuCount);
    }
    public static void main(String[] args) {
        SubwayCli subwayCli = new SubwayCli();
        System.out.println("어서오세요 서브웨이 입니다!!");
        subwayCli.chooseMenu();
    }
}