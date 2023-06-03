import pok.*;
import attacks.*;
import ru.ifmo.se.pokemon.*;
 
public class Game {

	public static void main(String[] args) {
        	Battle b = new Battle();
       		b.addAlly(new Suicune("Dag", 1));
        	b.addAlly(new Pawniard("Scooby-Doo", 1));
        	b.addAlly(new Bisharp("Rick", 1));
        	b.addFoe(new Slakoth("Morti", 1));
        	b.addFoe(new Vigoroth("Norbert", 1));
        	b.addFoe(new Slaking("Shaggy", 1));
        	b.go();
	}
}
 
