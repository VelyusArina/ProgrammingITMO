package Location;
import Enum.*;

public class Chair extends Furniture{

    public Chair(FurnitureDeterioration age,PlaceType placeType) {
        super(age, placeType);
    }

    @Override
    public String getName() {
        return "Кресло";
    }
}
