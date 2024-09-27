package histoire;


import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller preparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obelix", 25);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		Gaulois asterix = new Gaulois("asterix", 8);
		asterix.boirePotion(6);
		asterix.parler("Bonjour");
		Romain minus= new Romain("Minus",6);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
	}
	
	
	/* test tp2 */
}
