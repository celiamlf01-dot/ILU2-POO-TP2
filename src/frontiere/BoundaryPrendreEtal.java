package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		
		//TODO a completer
		if(!(controlPrendreEtal.verifierIdentite(nomVendeur)))
		{
			System.out.println("Je suis désolée  "+nomVendeur +" mais il faut être un habitant de notre village pour commercer ici.");
		}
		else {
			System.out.println("Bonjour Bonemine, je vais regardersi je peux vous trouver un étal.");
			boolean etalDisponible=controlPrendreEtal.resteEtals();
			if(!etalDisponible)
			{
				System.out.println("Je suis désolée  "+nomVendeur +" mais je n'ai plus d'etal qui ne soit pas deja occupe");
				
				
			}else
			{
				System.out.println("C'est parfait, il me reste un étal pour vous !");
				System.out.println("Il me faudrait quelques renseignements :");
				
				String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
				int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				if(numeroEtal!=-1)
				{
					System.out.println("Le vendeur"+ nomVendeur + "s'est installé à l'étal n°"+numeroEtal);
				}
				
			}
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		
		
	}
}
