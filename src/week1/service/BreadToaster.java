package week1.service;

public class BreadToaster {

    public String breadToast() {
        int count = 5;
        System.out.println("빵 굽기를 시작합니다.");
        try {
            while (count > 0) {
                Thread.sleep(1000);
                count--;
                System.out.println("남은 시간: " + count);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("띠디딕 - 띠디딕 - 빵을 꺼내주세요");
        return "조리 완료";
    }
}