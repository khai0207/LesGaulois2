package histoire;


import personnages.Gaulois;
import personnages.Romain;

public class Scenario {

	public static void main(String[] args) {

		Gaulois asterix = new Gaulois("asterix", 8);
		asterix.parler("Bonjour à tous");
		Romain minus= new Romain("Minus",6);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (minus.getForce() > 0);
	}

}
