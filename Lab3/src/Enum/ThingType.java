package Enum;

public enum ThingType {
    Birch("Березовое полено"),
    Oak("Дубовое полено"),
    Fir("Еловое полено");

    private final String log;
    ThingType(String log) {
        this.log = log;
    }

    @Override
    public String toString(){
        return log;
    }

}
