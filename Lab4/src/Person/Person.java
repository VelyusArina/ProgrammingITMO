package Person;

import Interfaces.WithName;
import Location.*;
import Things.Food;
import Things.Thing;

public interface Person extends WithName {


    void takeThing(Thing thing);

    void go(Furniture go); //Идти к какой-то вещи

    void toss(Furniture where); //подкинуть

    void lightOn();

    void lightOff();

    void up();

    void sit();

    void setMood(APerson.Mood mood);

    APerson.Mood getMood();

    void eat(Food food);

    void ask(Person person, String string);

    void answer(Person person, String string);

    void say(String string);
}
