package Enum;

public enum LocationType {
    Bedroom("Спальня"),
    HouseRoof("Домик на крыше"),
    Kitchen("Кухня"),
    LivingRoom("Гостиная");

    private final String location;

    LocationType(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return this.location;
    }

}
