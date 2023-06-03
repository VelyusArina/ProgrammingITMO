package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class FurySwipes extends PhysicalMove {
	public FurySwipes () {
		super (Type.NORMAL, 18.0, 80.0);
		}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
		if (Math.random()<0.375) {
			p.setMod (Stat.HP, (int) Math.round (2*damage));
			if (Math.random()<0.375) {
				p.setMod (Stat.HP, (int) Math.round (3*damage));
				if (Math.random()<0.125) {
					p.setMod (Stat.HP, (int) Math.round (4*damage));
					if (Math.random()<0.125) {
						p.setMod (Stat.HP, (int) Math.round (5*damage));
					}
				}
			}
		}
	}
	@Override
	protected String describe () {
		return "применяет атаку FurySwipes";
	}
}