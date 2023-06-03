package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class FocusBlast extends SpecialMove {
	public FocusBlast () {
		super (Type.FIGHTING, 120.0, 70.0);
	}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected void applyOppEffects (Pokemon p) {
		if (Math.random () <= 0.1) {
		p.setMod (Stat.SPECIAL_DEFENSE, -1);
		}
	}
    	@Override
	protected String describe(){
        	return "применяет атаку FocusBlast";
    	}
}