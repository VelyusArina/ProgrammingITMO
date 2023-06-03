package attacks;
import ru.ifmo.se.pokemon.*;
import java.lang.Math;

public class Swagger extends StatusMove {
	public Swagger () {
		super (Type.NORMAL, 0.0, 90.0);
	}
	@Override
	protected void applyOppEffects (Pokemon p) {
		p.setMod (Stat.ATTACK, 2);
		Effect.confuse (p);
	}
	@Override
	protected String describe(){
        return "применяет атаку Swagger";
    }
}