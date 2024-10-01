package personnages;

public class Musee {
	int nbTrophee;
	private Equipement trophees[] = new Equipement[200];

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = equipement;
		nbTrophee += 1;
	}

	public void extraireInstructionsCaml(Gaulois gaulois) {
		for (int i = 0; i < nbTrophee; i++) {
			String texte = "let musee [\n";

			for (int j = 0; j <= i; j++) {
				texte += "  \"" + gaulois.getNom() + "\", \"" + trophees[j] + "\"\n";
			}

			texte += "]";
			System.out.println(texte);
		}
	}
}
