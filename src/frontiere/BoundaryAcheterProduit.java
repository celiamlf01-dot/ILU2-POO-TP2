package frontiere;

import personnages.Gaulois;
import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentiteAcheteur(nomAcheteur);
		if (!nomAcheteurConnu) {
			System.out.println("Je suis désolée "+nomAcheteur+ " mais il faut être un habitant de notre village pour commencer ici. ");
		}
		else {
			String produit=Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			StringBuilder qstVendeur = new StringBuilder();
			
			Gaulois[] vendeurs = controlAcheterProduit.vendeurProduit(produit);
			
			if (vendeurs==null) {
				System.out.println("Désolé, personne ne vend ce produit au marché");
			}
			else {
				int n=vendeurs.length;
				qstVendeur.append("Chez quel commerçant voulez-vous acheter des "+produit +"? \n");
				for (int j = 0; j < vendeurs.length; j++) {
					qstVendeur.append(j+1).append(" - ").append(vendeurs[j].getNom()).append("\n");
				}
				int choixVendeur =0;
				choixVendeur = Clavier.entrerEntier(qstVendeur.toString());
				while (choixVendeur>n || choixVendeur<=0) {
					System.out.println("Vous devez entrer un chiffre entre 1 et "+n);
					choixVendeur = Clavier.entrerEntier(qstVendeur.toString());
				}
				controlAcheterProduit.acheterProduitVendeur(nomAcheteur,vendeurs[choixVendeur-1].getNom(),produit);
			}
		}
	}
}
		

