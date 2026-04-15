package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commencer ici. ");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			StringBuilder qstVendeur = new StringBuilder();

			String[] vendeurs = controlAcheterProduit.vendeurProduit(produit);

			if (vendeurs == null) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			} else {
				acheterPrduitVendeur(nomAcheteur, produit, qstVendeur, vendeurs);
			}
		}
	}

	private void acheterPrduitVendeur(String nomAcheteur, String produit, StringBuilder qstVendeur, String[] vendeurs) {
		
		qstVendeur.append("Chez quel commerçant voulez-vous acheter des " + produit + "? \n");
		for (int j = 0; j < vendeurs.length; j++) {
			qstVendeur.append(j + 1).append(" - ").append(vendeurs[j]).append("\n");
		}
		int choixVendeur = 0;
		choixVendeur = Clavier.entrerEntier(qstVendeur.toString());
		do  {
			System.out.println("Vous devez entrer un chiffre entre 1 et " + vendeurs.length);
			choixVendeur = Clavier.entrerEntier(qstVendeur.toString());
		}while(choixVendeur > vendeurs.length || choixVendeur <= 0);
		controlAcheterProduit.acheterProduitVendeur(nomAcheteur, vendeurs[choixVendeur - 1], produit);
	}
}
