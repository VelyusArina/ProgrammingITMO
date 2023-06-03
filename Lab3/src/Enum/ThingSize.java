package Enum;

public enum ThingSize {
    SMALL(1),
    MIDDLE(3),
    BIG(5);

    private final int type;

    ThingSize(int type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return String.valueOf(type);
    }
}
