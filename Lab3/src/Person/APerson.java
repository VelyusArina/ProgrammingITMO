package Person;

import Location.Furniture;
import Location.Lamp;
import Location.Thing;

import java.util.ArrayList;
import Enum.*;

public abstract class APerson implements Person{
    protected Furniture nearFurniture;
    protected ArrayList<Thing> thingsInHand;
    protected Mood mood;

    public APerson(Mood mood, Furniture nearFurniture) {
        this.mood = mood;
        thingsInHand = new ArrayList<Thing>();
        this.nearFurniture = nearFurniture;
    }

    @Override
    public void lightOn() {
        if (this.nearFurniture.getFurnitureType().equals(FurnitureType.LAMP)) {
            Lamp lamp = (Lamp) this.nearFurniture;
            if(!lamp.isOn()){
                lamp.lightOn();
            } else {
                System.out.println("Включили уже");
            }
        }
    }

    @Override
    public void lightOff() {
        if (this.nearFurniture.getFurnitureType().equals(FurnitureType.LAMP)) {
            Lamp lamp = (Lamp) this.nearFurniture;
            if(lamp.isOn()){
                lamp.lightOff();
            } else {
                System.out.println(" уже выключили");
            }
        }
    }

    @Override
    public void up() {
        System.out.println( getName() + " встал");
    }

    @Override
    public void set() {
        System.out.println( getName() + " сел");
    }

    @Override
    public int hashCode(){
        return toString().hashCode();
    }


}
