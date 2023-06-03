package Things;
import Enum.*;
import Things.Thing;

public class Clock extends Thing {

    public Clock(ThingSize thingSize) {
        super(thingSize);
    }

    @Override
    public String getName() {
        return " разбитый будильник ";
    }
}
