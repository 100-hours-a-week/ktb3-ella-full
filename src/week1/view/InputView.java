package week1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final static int Min = 1;
    private final static int BREAD_SMALL_SIZE = 15;
    private final static int BREAD_LARGE_SIZE = 30;

    Scanner scanner = new Scanner(System.in);

    public int selectSingleOption(String msg, int max) {
        System.out.println(msg);
        System.out.printf("%d ~ %d 중에 원하시는 것의 번호를 한개만 입력하세요\n", Min, max);
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice >= Min && choice <= max) {
                    return choice;
                }
                System.out.printf("!! %d ~ %d 사이의 번호를 입력하세요. !!\n", 1, max);
            } catch (NumberFormatException e) {
                System.out.println(" !! 숫자를 입력하세요. !!");
            }
        }
    }

    public List<Integer> selectMultiOptions(String msg, int max) {
        System.out.println(msg);
        System.out.printf("%d ~ %d 중에 원하시는 번호들을 ,(쉼표)를 통해 입력하세요(선택 안 함: Enter)\n", Min, max);
        List<Integer> choices = new ArrayList<>();
        while (true) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                return choices;
            }
            String[] numbers = line.split(",");
            boolean allValid = true;
            choices.clear();
            try {
                for (String numStr : numbers) {
                    int choice = Integer.parseInt(numStr.trim());
                    if (choice >= 1 && choice <= max) {
                        choices.add(choice);
                    } else {
                        System.out.printf("!! %d ~ %d 사이의 번호만 입력하세요. (잘못된 입력: %d) !!\n", Min, max, choice);
                        allValid = false;
                        break;
                    }
                }
                if (allValid) {
                    return choices;
                }
            } catch (NumberFormatException e) {
                System.out.println(" !! 숫자와 ,(쉼표) 만을 이용하여 입력하세요. !!");
            }
        }
    }

    public int selectBreadSize() {
        System.out.println("빵 크기를 선택해주세요");
        System.out.println("1. 15cm 2. 30cm");
        while (true) {
            String line = scanner.nextLine().trim();
            try{
                int choice = Integer.parseInt(line);
                if (choice >= 1 && choice <= 2) {
                    if(choice == 1){
                        return BREAD_SMALL_SIZE;
                    }else {
                        return BREAD_LARGE_SIZE;
                    }
                }
                System.out.print(" !! 1번 ~ 2번 사이의 번호만 입력하세요");
            }catch (NumberFormatException e) {
                System.out.println(" !! 숫자를 입력하세요. !!");
            }
        }
    }

    public boolean selectBreadToasted() {
        System.out.println("빵 구워드릴까요");
        System.out.println("1. 예 2. 아니요");
        while (true) {
            String line = scanner.nextLine().trim();
            try{
                int choice = Integer.parseInt(line);
                if (choice >= 1 && choice <= 2) {
                    if(choice == 1){
                        return true;
                    }else {
                        return false;
                    }
                }
                System.out.print(" !! 1번 ~ 2번 사이의 번호만 입력하세요");
            }catch (NumberFormatException e) {
                System.out.println(" !! 숫자를 입력하세요. !!");
            }
        }
    }
}
