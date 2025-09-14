package week1.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Choose {
    Scanner sc = new Scanner(System.in);

    public int oneChoose(String msg, int min, int max) {
        System.out.print(msg);
        System.out.printf("\n%d ~ %d 중에 원하시는 것의 번호를 한개만 입력하세요\n", min, max);
        while (true){
            String line = sc.nextLine().trim();
            try {
                int choice = Integer.parseInt(line);
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.printf("!! %d ~ %d 사이의 번호를 입력하세요. !!\n", min, max);
            } catch (NumberFormatException e) {
                System.out.println(" !! 숫자를 입력하세요. !!");
            }
        }
    }
    public List<Integer> manyChoose(String msg, int min, int max) {
        System.out.print(msg);
        System.out.printf("\n%d ~ %d 중에 원하시는 번호들을 ,(쉼표)를 통해 입력하세요(선택 안 함: Enter)\n", min, max);
        List<Integer> choices = new ArrayList<>();
        while (true) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                return choices;
            }
            String[] numbers = line.split(",");
            boolean allValid = true;
            choices.clear();
            try {
                for (String numStr : numbers) {
                    int choice = Integer.parseInt(numStr.trim());
                    if (choice >= min && choice <= max) {
                        choices.add(choice);
                    } else {
                        System.out.printf("!! %d ~ %d 사이의 번호만 입력하세요. (잘못된 입력: %d) !!\n", min, max, choice);
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
}
