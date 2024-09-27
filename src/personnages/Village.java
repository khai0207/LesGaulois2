package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private int nbVillageois = 0;
	private Gaulois[] villageois;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		// Vérifier s'il reste de la place dans le village
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois; // Ajouter le gaulois au tableau
			nbVillageois++; // Incrémenter le nombre de villageois
		} else {
			System.out.println("Le village est plein, impossible d'ajouter de nouveaux habitants.");
		}
	}

	public Gaulois trouverHabitant(int numVillageois) {
		return villageois[numVillageois];
	}

	public void afficherVillageois() {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les legendaires gaulois ");

		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- "+villageois[i].getNom());

		}

	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30); 
//		Index 30 out of bounds for length 30 
//		nbVillageoisMaximum est 30 alors 0<=nbVillageois<=29
		Chef chef = new Chef("Abraracourcix", 6, village);
		village.setChef(chef);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Null
//		car asterix a ete ajoute villageois[0] pas villageois[1] alors villageois[1]est null
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
