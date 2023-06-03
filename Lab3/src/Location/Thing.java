package Location;

import Enum.*;
import Interfaces.*;

public class Thing implements ILightable, WithName{
    private ThingType thingType;
    private Furniture inFurniture;
    private int entirety;
    private ThingSize thingSize;

    public Thing(ThingType thingType, ThingSize thingSize) {
        this.thingType = thingType;
        this.thingSize = thingSize;
        this.entirety = 100;
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
    }

    @Override
    public String getName() {
        return thingType.toString();
    }

    public void setFurniture(Furniture where) {
        this.inFurniture = where;
    }

    public int getEntirety() {
        return entirety;
    }

    public void setEntirety(int entirety) {
        this.entirety = entirety;
    }

    public ThingSize getThingSize() {
        return thingSize;
    }

    @Override
    public String toString() {
        return this.thingType.toString();
    }

    @Override
    public int hashCode(){
        return thingType.hashCode()* (inFurniture.hashCode()+31) + thingSize.hashCode();
    }
}
