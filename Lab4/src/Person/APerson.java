package Person;

import Enum.*;
import Location.*;
import Things.Food;
import Things.Thing;

import java.util.ArrayList;
import java.util.Objects;

public abstract class APerson implements Person{
    protected Furniture nearFurniture;
    protected ArrayList<Thing> thingsInHand;
    protected Mood mood;
    protected LocationType locationType;

    public APerson(Mood mood, Furniture nearFurniture, LocationType locationType) {
        this.mood = mood;
        thingsInHand = new ArrayList<Thing>();
        this.nearFurniture = nearFurniture;
        this.locationType = locationType;
    }

    @Override
    public void setMood(Mood mood) {
        this.mood = mood;
    }

    @Override
    public Mood getMood() {
         return mood;
    }

    @Override
    public void lightOn() {
        if (this.nearFurniture instanceof Lamp) {
            Lamp lamp = (Lamp) this.nearFurniture;
            if(!lamp.isOn()){
                lamp.lightOn();
            } else {
                System.out.println("Включили уже");
            }
        }
    }

    @Override
    public void lightOff() {
        if (this.nearFurniture instanceof Lamp) {
            Lamp lamp = (Lamp) this.nearFurniture;
            if(lamp.isOn()){
                lamp.lightOff();
            } else {
                System.out.println(" уже выключили");
            }
        }
    }

    @Override
    public void up() {
        System.out.println( getName() + " встал");
    }

    @Override
    public void sit() {
        System.out.println( getName() + " сел");
    }

    @Override
    public void eat(Food food) {
        System.out.println( getName() + " съел " + food.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APerson aPerson = (APerson) o;
        return Objects.equals(nearFurniture, aPerson.nearFurniture) && Objects.equals(thingsInHand, aPerson.thingsInHand) && mood == aPerson.mood && locationType == aPerson.locationType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nearFurniture, thingsInHand, mood, locationType);
    }

    @Override
    public void ask(Person person, String string) {
        System.out.println(this.getName() + " спрашивает " + person.getName() + ": " + string);
    }

    @Override
    public void answer(Person person, String string) {
        System.out.println(this.getName() + " ответил " + person.getName() + ": " + string);
    }

    @Override
    public void say( String string) {
        System.out.println(this.getName() + " говорит " + ": " + string);
    }

    @Override
    public void takeThing(Thing thing) {
        System.out.println(getName() + " взял в руки " + thing.toString());
        this.thingsInHand.add(thing);
    }

    @Override
    public void go(Furniture go) {
        System.out.println(getName() + " идет к " + go.toString());
        if (this.nearFurniture.getAge().equals(FurnitureDeterioration.OLD)) {
            this.mood = Mood.Sad;
        } else if (this.nearFurniture.getAge().equals(FurnitureDeterioration.NEW)) {
            this.mood = Mood.Happy;
        }
        this.nearFurniture = go;
    }

    @Override
    public void toss(Furniture where) {
        if (this.thingsInHand.size() == 0) {
            System.out.println(getName() + " ничего не держит в руках");
            return;
        }
        if (this.nearFurniture instanceof FurnitureWithThings) {
            FurnitureWithThings furnitureWithThings = (FurnitureWithThings) this.nearFurniture;
            for (Thing thing : thingsInHand) {
                try {
                    furnitureWithThings.addThing(thing);
                } catch (Exception e) {
                    System.out.println("ERROR ---> " + e.getMessage());
                    return;
                }
                System.out.println(getName() + " кидает " + thing.toString() + " в " + nearFurniture.toString());
                thing.setFurniture(where);
            }
            thingsInHand.clear();
        }
    }

    public enum Mood {
        Happy("Счастливый"),
        Caml("Спокойные"),
        Sad("Грустный");

        private final String mood;

        Mood(String mood) {
            this.mood = mood;
        }

        @Override
        public String toString(){
            return mood;
        }

    }
}
