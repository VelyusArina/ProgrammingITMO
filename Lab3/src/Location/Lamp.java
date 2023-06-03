package Location;

import Enum.*;
import Interfaces.ILight;
import Interfaces.WithName;

public abstract class Lamp extends Furniture implements ILight, WithName {

    private boolean isOn;

    public Lamp(FurnitureDeterioration age, PlaceType placeType) {
        super(FurnitureType.LAMP, age, placeType);
        this.isOn = false;

    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public void lightOn() {
        System.out.println(getName()+" загорелась "+ getColor().toString()+" цветом " + getPlace());
        location.lightUp();
    }

    @Override
    public void lightOff() {
        System.out.println(getName()+" выключилась");
    }
}
