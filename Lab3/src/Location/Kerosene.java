package Location;

import Enum.*;

public class Kerosene extends Lamp{

    public Kerosene(FurnitureDeterioration age, PlaceType placeType) {
        super(age, placeType);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public String getName() {
        return LampType.Gerasimova.toString();
    }
}
