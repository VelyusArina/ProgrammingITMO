package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class Scratch extends PhysicalMove {
	public Scratch () {
		super (Type.NORMAL, 40.0, 100.0);
		}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected String describe () {
		return "применяет атаку Scratch";
	}
}