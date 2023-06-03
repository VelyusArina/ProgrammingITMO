package pok;
import attacks.*;
import ru.ifmo.se.pokemon.*;

public class Bisharp extends Pawniard {
	public Bisharp (String name, int level) {
		super (name, level);
		setStats (65, 125, 100, 60, 70, 70);
		setType (Type.DARK, Type.STEEL);
		addMove (new FocusBlast());
	}
}