package Things;

import Enum.*;
import Interfaces.*;
import Location.Furniture;

import java.util.Objects;

public abstract class Thing implements ILightable, WithName{

    private Furniture inFurniture;
    private int entirety;
    private ThingSize thingSize;

    public Thing(ThingSize thingSize) {
        this.thingSize = thingSize;
        this.entirety = 100;
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
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
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return entirety == thing.entirety && Objects.equals(inFurniture, thing.inFurniture) && thingSize == thing.thingSize;
    }

    @Override
    public int hashCode(){
        return getName().hashCode()* (inFurniture.hashCode()+31) + thingSize.hashCode();
    }
}
