package Things;
import Enum.*;
import Things.Log;

public class Birch extends Log {


    public Birch(ThingSize thingSize) {
        super(thingSize);
    }

    @Override
    public String getType() {
        return "березовое";
    }
}
