package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class Slash extends PhysicalMove {
	public Slash () {
		super (Type.NORMAL, 70.0, 100.0);
		}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected double calcCriticalHit (Pokemon att, Pokemon def) {
		if (att.getStat(Stat.SPEED) / 8.0 > Math.random()) {
            return 2.0;
        }
        return 1.0;
	}
	@Override
	protected String describe () {
		return "применить атаку Slash";
	}
}