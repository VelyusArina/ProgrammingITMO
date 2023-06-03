package Location;

import Enum.*;
import Interfaces.*;

import java.util.Objects;

public abstract class Furniture implements IPlace, ILightable, WithName {
    private FurnitureDeterioration age;
    private PlaceType placeType;
    protected Location location;

    public Furniture(FurnitureDeterioration age, PlaceType placeType) {
        this.age = age;
        this.placeType = placeType;
        this.location = null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
    }

    public FurnitureDeterioration getAge() {
        return age;
    }

    @Override
    public String getPlace() {
        return placeType.toString();
    }



    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Furniture furniture = (Furniture) o;
        return age == furniture.age && placeType == furniture.placeType && Objects.equals(location, furniture.location);
    }

    @Override
    public int hashCode() {
        return getName().hashCode() * (placeType.hashCode() + 31) * age.hashCode() + location.hashCode();
    }

}
