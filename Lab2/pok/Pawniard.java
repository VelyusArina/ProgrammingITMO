package pok;
import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Pawniard extends Pokemon {
	public Pawniard (String name, int level) {
		super (name, level);
		setStats (45, 85, 70, 40, 40, 60);
		setType (Type.DARK, Type.STEEL);
		setMove (new Slash(), new Swagger(), new MetalClaw());
	}
}