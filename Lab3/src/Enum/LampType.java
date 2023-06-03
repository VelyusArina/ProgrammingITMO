package Enum;

public enum LampType {
    Gerasimova ("Керасиновую лампу"),
    Neon("Неоновую лампу"),
    Halogen("Галогеновую лампу");

    private final String lamp;

    LampType(String lamp) {
        this.lamp = lamp;
    }

    @Override
    public String toString(){
        return lamp;
    }
}
