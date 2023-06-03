package Enum;

public enum Color {
    RED("Красный"),
    BLUE("Синий"),
    YELLOW("Желтый");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString(){
        return color;
    }
}
