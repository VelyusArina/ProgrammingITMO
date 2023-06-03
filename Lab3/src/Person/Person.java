package Person;

import Interfaces.WithName;
import Location.*;

public interface Person extends WithName {


    void takeThing(Thing thing);

    void go(Furniture go); //Идти к какой-то вещи

    void toss(Furniture where); //подкинуть

    void lightOn();

    void lightOff();

    void up();

    void set();
}
