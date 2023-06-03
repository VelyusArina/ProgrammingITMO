package Location;
import Enum.*;

public class Workbench extends FurnitureWithThings{

    public Workbench(FurnitureDeterioration age, PlaceType placeType, int capacity) {
        super(age, placeType, capacity);
    }

    @Override
    public String getName() {
        return "Верстак";
    }
}
