package Person;

import Interfaces.ILight;
import Location.*;
import Enum.*;

import java.util.ArrayList;

public class Carlson extends APerson{

    public Carlson(Mood mood, Furniture nearFurniture) {
        super(mood, nearFurniture);
    }

    @Override
    public String getName(){
        return "Карлсон";
    }


    @Override
    public void takeThing(Thing thing) {
        System.out.println(getName() + " взял в руки " + thing.toString());
        this.thingsInHand.add(thing);
    }

    @Override
    public void go(Furniture go) {
        System.out.println(getName() + " идет к " + go.toString());
        if (this.nearFurniture.getAge().equals(FurnitureDeterioration.OLD)) {
            this.mood = Mood.Sad;
        } else if (this.nearFurniture.getAge().equals(FurnitureDeterioration.NEW)) {
            this.mood = Mood.Happy;
        }
        this.nearFurniture = go;
    }

    @Override
    public void toss(Furniture where) {
        if (this.thingsInHand.size() == 0) {
            System.out.println(getName() + " ничего не держит в руках");
            return;
        }
        for (Thing thing : thingsInHand) {
            System.out.println(getName() + " кидает " + thing.toString() + " в " + nearFurniture.toString());
            thing.setFurniture(where);
            this.nearFurniture.setIn(thing);
        }
        thingsInHand.clear();
    }

    public void burnFurn() {
        if (this.nearFurniture.getFurnitureType().equals(FurnitureType.FIREPLACE)) {
            Fireplace fireplace = (Fireplace) this.nearFurniture;
            fireplace.burn();
        }
    }


}
