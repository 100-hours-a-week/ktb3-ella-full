package week1.view;

public enum ToastingOption {
    YES(1, true, "예"),
    NO(2, false, "아니요");

    private final int menuNumber;
    private final boolean isToasted;
    private final String description;

    ToastingOption(int menuNumber, boolean isToasted, String description) {
        this.menuNumber = menuNumber;
        this.isToasted = isToasted;
        this.description = description;
    }

    public int getMenuNumber() { return menuNumber; }
    public boolean isToasted() { return isToasted; }
    public String getDescription() { return description; }

    public static ToastingOption fromMenuNumber(int number) {
        for (ToastingOption option : values()) {
            if (option.menuNumber == number) {
                return option;
            }
        }
        throw new IllegalArgumentException("선택지에 없는 번호입니다: " + number);
    }
}
