package Person;

import Enum.*;
import Interfaces.IFly;
import Location.*;
import Things.Food;

import java.util.ArrayList;

public class Carlson extends APerson implements IFly {

    public Carlson(Mood mood, Furniture nearFurniture, LocationType locationType) {
        super(mood, nearFurniture, locationType);
    }

    @Override
    public void fly(LocationType locationType) {
        System.out.println(getName() + " улетел в " + locationType.toString());
    }

    public void bake(ArrayList<Food> foods) {
        for (Food food : foods) {
            System.out.println(getName() + " запек " + food.getName());
            food.bake();
        }
    }

    public void wearIt(ArrayList<Food> foods) {
        for (Food food : foods) {
            System.out.println(getName() + " нанизывает " + food.getName());
        }
    }


    @Override
    public String getName() {
        return "Карлсон";
    }


    public void burnFurn() {
        if (this.nearFurniture instanceof Fireplace) {
            Fireplace fireplace = (Fireplace) this.nearFurniture;
            fireplace.burn();
        }
    }

}
