package Person;

import Location.Furniture;
import Enum.*;
import exception.MyUncheckedException;

public class Baby extends APerson {

    public Baby(Mood mood, Furniture nearFurniture, LocationType locationType) {
        super(mood, nearFurniture, locationType);
    }

    @Override
    public String getName() {
        return "Малыш";
    }


    public void think(){
        System.out.println(getName() + " подумал: Как хорошо, когда трещат поленья! Дни стали холодными. По всему видно, что пришла осень.");
    }

    @Override
    public void toss(Furniture where) {
        throw new MyUncheckedException();
    }
}
