package domain;

import java.util.Scanner;

public class Choose {
    Scanner sc = new Scanner(System.in);

    public int oneChoose(String msg, int min, int max) {
        System.out.print(msg);
        System.out.printf("%d ~ %d 중에 원하시는 것의 번호를 입력하세요\n", min, max);
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
}
