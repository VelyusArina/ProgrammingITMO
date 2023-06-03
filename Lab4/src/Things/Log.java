package Things;
import Enum.*;
import Things.Thing;

public abstract class Log extends Thing {

    public Log(ThingSize thingSize) {
        super(thingSize);
    }

    public abstract String getType();

    @Override
    public String getName() {
        return getType() + " полено";
    }
}
