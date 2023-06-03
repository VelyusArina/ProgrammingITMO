import Enum.*;
import Location.*;
import Person.*;
import Things.*;

import java.util.ArrayList;

public class Story {
   public static void main(String[] args) {
      Location location = new Location(LocationType.HouseRoof);
      Chair chair = new Chair(FurnitureDeterioration.NEW, PlaceType.RightCorner);
      Workbench workbench = new Workbench(FurnitureDeterioration.NORMAL, PlaceType.RightCorner, 3);
      Clock clock = new Clock(ThingSize.SMALL);
      JarOfJam jarOfJam = new JarOfJam(ThingSize.BIG);
      Propeller propeller = new Propeller(ThingSize.MIDDLE);
      Fireplace fireplace = new Fireplace(FurnitureDeterioration.OLD, PlaceType.NearWindow, 2);
      Table table = new Table(FurnitureDeterioration.NEW, PlaceType.LeftCorner);
      Lamp lamp = new Kerosene(FurnitureDeterioration.OLD, PlaceType.UnderCeiling);
      location.addObject(chair);
      location.addObject(workbench);
      location.addObject(fireplace);
      location.addObject(table);
      location.addObject(lamp);
      try {
         workbench.addThing(propeller);
         workbench.addThing(jarOfJam);
         workbench.addThing(clock);
      } catch (Exception e) {
         System.out.println("ERROR ---> " + e.getMessage());
      }
      Birch birch = new Birch(ThingSize.BIG);
      birch.setFurniture(chair);

      class FirLog extends Log {

         public FirLog(ThingSize thingSize) {
            super(thingSize);
         }

         @Override
         public String getType() {
            return "еловое";
         }
      }

      FirLog birch1 = new FirLog(ThingSize.BIG);
      birch1.setFurniture(chair);
      Carlson carlson = new Carlson( APerson.Mood.Caml, fireplace, location.getLocationType());
      Baby baby = new Baby(APerson.Mood.Caml, fireplace, location.getLocationType());
      ArrayList<Food> foods = new ArrayList<Food>();
      foods.add(new Food() {
         @Override
         public String getType() {
            return "яблоко";
         }
      });
      foods.add(new Food.AppleStatic());
      carlson.wearIt(foods);
      carlson.bake(foods);
      carlson.eat(foods.get(0));
      baby.eat(foods.get(1));
      baby.think();
      carlson.up();
      carlson.takeThing(birch);
      carlson.takeThing(birch1);
      carlson.go(fireplace);
      carlson.toss(fireplace);
      carlson.burnFurn();
      carlson.go(workbench);
      carlson.go(lamp);
      carlson.lightOn();
      baby.ask(carlson,"Можем ли мы чем-нибудь обменяться?");
      carlson.answer(baby, "Я готов обменяться");
      for (Thing thing : workbench.getThings()){
         baby.ask(carlson,"Могу ли я взять " + thing.getName() + "?");
         if (thing instanceof Clock) {
            carlson.answer(baby, "Да, бери! Этот будильник я когда-то сам разбирал и собирал.");
            baby.say(" Эта игра была такой интересной, что я не мог себе этого представить");
            break;
         } else {
            carlson.answer(baby, "Нет!");
         }
      }
      baby.toss(fireplace); //здесь непроверяемое исключение
   }
}
