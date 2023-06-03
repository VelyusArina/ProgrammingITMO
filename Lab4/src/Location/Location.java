package Location;
import Enum.*;
import Interfaces.ILightable;
import Interfaces.WithName;

import java.util.ArrayList;
import java.util.Objects;

public class Location implements ILightable, WithName {
    private LocationType locationType;
    private ArrayList<Furniture> furnitures;

    public Location(LocationType locationType) {
        this.locationType = locationType;
        this.furnitures = new ArrayList<Furniture>();
    }

    public LocationType getLocationType(){
        return locationType;
    }

    @Override
    public void lightUp() {
        System.out.println(getName() + " осветился");
        for (Furniture furniture : furnitures){
            furniture.lightUp();
        }
    }

    @Override
    public String getName() {
        return locationType.toString();
    }

    public void addObject(Furniture furniture) {
        furnitures.add(furniture);
        furniture.setLocation(this);
    }

    public void deleteObject(Furniture furniture) {
        furnitures.remove(furniture);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return locationType == location.locationType && Objects.equals(furnitures, location.furnitures);
    }

    @Override
    public int hashCode(){
        return locationType.hashCode();
    }
}
