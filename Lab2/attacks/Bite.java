package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class Bite extends PhysicalMove {
	public Bite () {
		super (Type.DARK, 60.0, 100.0);
	}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected void applyOppEffects (Pokemon p) {
		if (Math.random () <= 0.3) {
			Effect.flinch (p);
		}
	}
	@Override
	protected String describe () {
		return "применяет атаку Bite";
	}
}