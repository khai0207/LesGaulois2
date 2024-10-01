package personnages;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Gaulois {
	private static final Logger LOGGER = Logger.getLogger(Gaulois.class.getName());
	private String nom;
	private int effetPotion = 1;
	private int force, nb_trophees;
	private Equipement trophees[] = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info(prendreParole() + "<< " + texte + ">>");
		}
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}

//	public void frapper(Romain romain) {
//		LOGGER.info(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	public void frapper(Romain romain) {
		LOGGER.info(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
		Equipement trophees[] = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
		return;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois decuplee.");
	}

	public void faireUneDonnation(Musee musee) {
	    if (nb_trophees != 0) {
	        String texte = "Je donne au musee tous mes trophees : ";
	        for (int i = 0; i < nb_trophees; i++) {
	            if (trophees[i] != null) { 
	                texte += "\n- " + trophees[i];
	                musee.donnerTrophees(this, trophees[i]);
	                trophees[i] = null; 
	            }
	        }
	        nb_trophees = 0; 
	        parler(texte); 
	    }
	}


	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		LOGGER.info(String.format("Gaulois: %s", asterix));
		LOGGER.info("Test methode getNom");
		LOGGER.info(asterix.getNom());
		LOGGER.info("Test methode prendreParole");
		LOGGER.info(asterix.prendreParole());
		LOGGER.info("Test methode parler");
		asterix.parler("Bonjour");
		LOGGER.info("Test methode frapper");
		asterix.frapper(new Romain("Minus", 9));
		LOGGER.info("Test methode boirePotion");
		asterix.boirePotion(10);
		LOGGER.info("Test methode faireUneDonnation");
	}
}
