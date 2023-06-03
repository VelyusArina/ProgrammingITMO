package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class RockTomb extends PhysicalMove {
	public RockTomb () {
		super (Type.ROCK, 60.0, 95.0);
		}
	@Override
	protected void applyOppDamage (Pokemon p, double damage) {
		p.setMod (Stat.HP, (int) Math.round (damage));
	}
	@Override
	protected void applyOppEffects(Pokemon def) {
		def.setMod(Stat.SPEED, -1);
	}
	@Override
	protected String describe () {
		return "применяет атаку RockTomb";
	}
}