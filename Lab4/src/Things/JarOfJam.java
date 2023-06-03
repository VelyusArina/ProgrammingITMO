package Things;
import Enum.*;
import Things.Thing;

public class JarOfJam extends Thing {

    public JarOfJam(ThingSize thingSize) {
        super(thingSize);
    }

    @Override
    public String getName() {
        return " банка с вареньем ";
    }
}
