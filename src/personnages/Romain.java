package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + ">>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert force > 0;
		int oldForce = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aie");
		} else {
			parler("J'abandonne...");
		}
		assert force < oldForce;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2: {
			System.out.println("le soldat " + nom + " est deja bien protege! ");
			break;
		}
		case 1: {
			if (equipements[0] == equipement) {
				System.out.println("le soldat " + nom + " possede deja un " + equipement + "!");
				break;
			}

			else {
				equipement(equipement);
				break;
			}
		}

		default: {
			equipement(equipement);
			break;

		}

		}
	}

	private void equipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'equipe avec un " + equipement + ".");

	}

	public static void main(String[] args) {

//			System.out.println("Test avec force nulle ou négative");
//			Romain minus = new Romain("Minus", -6);
		Romain minus = new Romain("Minus", 6);
		System.out.println("Test methode prendreParole");
		minus.prendreParole();
		System.out.println("Test methode parler");
		minus.parler("Bonjour");
		System.out.println("Test methode recevoirCoup");
		minus.recevoirCoup(6);

		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
}
