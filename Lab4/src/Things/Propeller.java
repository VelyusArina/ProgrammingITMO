package Things;
import Enum.*;
import Things.Thing;

public class Propeller extends Thing {

    public Propeller(ThingSize thingSize) {
        super(thingSize);
    }

    @Override
    public String getName() {
        return " пропеллер";
    }
}
