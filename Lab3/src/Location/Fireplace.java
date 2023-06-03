package Location;

import Enum.*;
import Interfaces.IBurn;

public class Fireplace extends Furniture implements IBurn {

    public Fireplace(FurnitureDeterioration age, PlaceType placeType) {
        super(FurnitureType.FIREPLACE, age, placeType);
    }


    @Override
    public void burn() {
        System.out.println("Камин горит "+ getPlace());
        for (Thing thing : getIn()) {
            int capacity = thing.getEntirety();
            while (capacity > 0) {
                capacity -= 15 / (Integer.parseInt(thing.getThingSize().toString()));
            }
            thing.setEntirety(0);
            System.out.println(thing.toString() + " сгорело");
        }
        super.clearIn();
        System.out.println("Камин потух");
    }
}
