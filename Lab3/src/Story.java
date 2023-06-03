import Location.*;
import Enum.*;
import Person.*;

public class Story {
   public static void main(String[] args) {
      Location location = new Location(LocationType.LivingRoom);
      Furniture chair = new Furniture(FurnitureType.CHAIR, FurnitureDeterioration.NEW, PlaceType.RightCorner);
      Furniture workbench = new Furniture(FurnitureType.WORKBENCH, FurnitureDeterioration.NORMAL, PlaceType.RightCorner);
      Fireplace fireplace = new Fireplace(FurnitureDeterioration.OLD, PlaceType.NearWindow);
      Furniture table = new Furniture(FurnitureType.TABLE, FurnitureDeterioration.NEW, PlaceType.LeftCorner);
      Lamp lamp = new Kerosene(FurnitureDeterioration.OLD, PlaceType.UnderCeiling);
      location.addObject(chair);
      location.addObject(workbench);
      location.addObject(fireplace);
      location.addObject(table);
      location.addObject(lamp);
      Thing thing1 = new Thing(ThingType.Birch, ThingSize.BIG);
      thing1.setFurniture(chair);
      Thing thing2 = new Thing(ThingType.Birch, ThingSize.BIG);
      thing2.setFurniture(chair);
      Carlson carlson = new Carlson( Mood.Happy, chair);
      carlson.up();
      carlson.takeThing(thing1);
      carlson.takeThing(thing2);
      carlson.go(fireplace);
      carlson.toss(fireplace);
      carlson.burnFurn();
      carlson.go(workbench);
      carlson.go(lamp);
      carlson.lightOn();
      carlson.go(chair);
      carlson.set();
   }
}
