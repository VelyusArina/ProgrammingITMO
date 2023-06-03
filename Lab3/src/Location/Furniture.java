package Location;

import Enum.*;
import Interfaces.*;

import java.util.ArrayList;

public class Furniture implements IPlace, ILightable, WithName {
    private FurnitureType furnitureType;
    private FurnitureDeterioration age;
    private ArrayList<Thing> in;
    private PlaceType placeType;
    protected Location location;

    public Furniture(FurnitureType furnitureType, FurnitureDeterioration age, PlaceType placeType) {
        this.furnitureType = furnitureType;
        this.age = age;
        in = new ArrayList<>();
        this.placeType = placeType;
        this.location = null;


    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
        for (Thing thing : in){
            thing.lightUp();
        }
    }

    @Override
    public String getName() {
        return furnitureType.toString();
    }

    public FurnitureDeterioration getAge() {
        return age;
    }

    public void clearIn() {
        in.clear();
    }

    @Override
    public String getPlace() {
        return placeType.toString();
    }

    public void setIn(Thing toIn) {
        this.in.add(toIn);
    }

    public ArrayList<Thing> getIn() {
        return in;
    }

    public FurnitureType getFurnitureType() {
        return furnitureType;
    }

    @Override
    public String toString() {
        return furnitureType.toString();
    }

    @Override
    public int hashCode() {
        return furnitureType.hashCode() * (placeType.hashCode() + 31) * age.hashCode() + location.hashCode();
    }
}
