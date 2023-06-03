package Location;
import Enum.*;
import Interfaces.ILightable;
import Interfaces.WithName;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;

public class Location implements ILightable, WithName {
    private LocationType locationType;
    private ArrayList<Furniture> furnitures;

    public Location(LocationType locationType) {
        this.locationType = locationType;
        this.furnitures = new ArrayList<Furniture>();
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
    public int hashCode(){
        return locationType.hashCode();
    }
}
