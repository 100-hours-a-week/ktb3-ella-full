package week1.view;

public enum BreadSize {
    SIZE_15(1, 15, "15cm"),
    SIZE_30(2, 30, "30cm");

    private final int menuNumber;
    private final int sizeValue;
    private final String description;

    BreadSize(int menuNumber, int sizeValue, String description) {
        this.menuNumber = menuNumber;
        this.sizeValue = sizeValue;
        this.description = description;
    }

    public int getMenuNumber() { return menuNumber; }
    public int getSizeValue() { return sizeValue; }
    public String getDescription() { return description; }

    public static BreadSize fromMenuNumber(int number) {
        for (BreadSize size : values()) {
            if (size.menuNumber == number) {
                return size;
            }
        }
        throw new IllegalArgumentException("선택지에 없는 번호입니다: " + number);
    }
}
