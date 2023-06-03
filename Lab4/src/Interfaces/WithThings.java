package Interfaces;

import Things.Thing;

import java.util.ArrayList;

public interface WithThings {
    ArrayList<Thing> getThings();

    void addThing(Thing thing) throws Exception;

    void clearThings();
}
