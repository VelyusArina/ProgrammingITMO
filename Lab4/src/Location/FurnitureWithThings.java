package Location;

import Interfaces.WithThings;
import Enum.*;
import Things.Thing;
import exception.MyCheckedException;

import java.util.ArrayList;

public abstract class FurnitureWithThings extends Furniture implements WithThings {
    protected ArrayList<Thing> things;
    protected int capacity;

    public FurnitureWithThings(FurnitureDeterioration age, PlaceType placeType,int capacity) {
        super(age, placeType);
        this.things = new ArrayList<Thing>();
        this.capacity = capacity;
    }

    @Override
    public void addThing(Thing thing) throws MyCheckedException {
        if(things.size() == capacity){
            throw new MyCheckedException();
        }
        this.things.add(thing);
    }

    @Override
    public ArrayList<Thing> getThings() {
        return things;
    }

    @Override
    public void clearThings() {
        things.clear();
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
        for (Thing thing : things){
            thing.lightUp();
        }
    }
}
