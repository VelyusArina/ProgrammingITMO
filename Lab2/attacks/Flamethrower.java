package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class Flamethrower extends SpecialMove {
	public Flamethrower () {
		super (Type.FIRE, 90.0, 100.0);
	}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected void applyOppEffects (Pokemon p) {
		if (Math.random () <= 0.1) {
			Effect.burn (p);
		}
	}
    	@Override
	protected String describe(){
        	return "применяет атаку Flamethrower";
    	}
}
