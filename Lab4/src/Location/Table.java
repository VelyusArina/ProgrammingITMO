package Location;
import Enum.*;

public class Table extends Furniture{

    public Table(FurnitureDeterioration age, PlaceType placeType) {
        super(age, placeType);
    }

    @Override
    public String getName() {
        return "Стол";
    }
}
