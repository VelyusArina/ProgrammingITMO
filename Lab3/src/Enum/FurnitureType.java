package Enum;

public enum FurnitureType {
    CHAIR("Кресло"),
    WORKBENCH("Верстак"),
    FIREPLACE("Камин"),
    LAMP("Лампа"),
    TABLE("Стол");

    private final String type;

    FurnitureType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return type;
    }
}
