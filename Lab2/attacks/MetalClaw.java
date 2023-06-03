package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class MetalClaw extends PhysicalMove {
	public MetalClaw () {
		super (Type.STEEL, 50.0, 95.0);
	}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected void applyOppEffects (Pokemon p) {
		if (Math.random () <= 0.1) {
			p.setMod (Stat.ATTACK,1);
		}
	}
    	@Override
	protected String describe(){
        	return "применяет атаку Flamethrower";
    	}
}
