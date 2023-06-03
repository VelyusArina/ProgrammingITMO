package pok;
import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Suicune extends Pokemon {
	public Suicune (String name, int level) {
		super (name, level);
		setStats (100, 75, 115, 90, 115, 85);
		setType (Type.WATER);
		setMove (new AuroraBeam(), new Bite(), new Swagger(), new BubbleBeam());
	}
}