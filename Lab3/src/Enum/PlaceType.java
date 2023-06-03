package Enum;

public enum PlaceType {
    UnderCeiling("над потолок"),
    OnWorkbench("на верстаке"),
    NearWindow("у окна"),
    LeftCorner("левый угол"),
    RightCorner("правый угол");

    private final String place;

    PlaceType(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return this.place;
    }
}
