package Location;

import Enum.*;
import Interfaces.IBurn;
import Things.Thing;

public class Fireplace extends FurnitureWithThings implements IBurn {

    public Fireplace(FurnitureDeterioration age, PlaceType placeType, int capacity) {
        super(age, placeType, capacity);
    }

    @Override
    public void burn() {
        System.out.println("Камин горит "+ getPlace());
        for (Thing thing : getThings()) {
            int capacity = thing.getEntirety();
            while (capacity > 0) {
                capacity -= 15 / (Integer.parseInt(thing.getThingSize().toString()));
            }
            thing.setEntirety(0);
            System.out.println(thing.toString() + " сгорело");
        }
        super.clearThings();
        System.out.println("Камин потух");
    }

    @Override
    public String getName() {
        return "Камин";
    }

}
