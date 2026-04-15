package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {

	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {

		boolean nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);

		if (!nomVendeurConnu) {
			System.out.println("Je suis désolée " + nomVendeur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");

			boolean etalDisponible = controlPrendreEtal.resteEtals();

			if (!etalDisponible) {
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occpé.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {

		StringBuilder questionProduit = new StringBuilder();

		questionProduit.append("C'est parfait, il me reste un étal pour vous!\n");
		questionProduit.append("Il me faudrait quelques renseignements.\n");
		questionProduit.append("Quel produit souhaitez-vous vendre?\n");

		String produit = Clavier.entrerChaine(questionProduit.toString());

		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre?");

		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);

		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + (numeroEtal + 1));
		}
	}
}