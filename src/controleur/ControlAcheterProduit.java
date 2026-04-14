package controleur;
import villagegaulois.*;
import frontiere.Clavier;
import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] vendeurProduit(String produit) {
		return  village.rechercherVendeursProduit(produit);
	}
	
	public boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	public void acheterProduitVendeur(String nomAcheteur,String nomVendeur,String produit) {
		StringBuilder qst = new StringBuilder();
		qst.append(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+nomVendeur+"\n");
		qst.append("Combien de "+produit+" voulez-vous acheter?\n");
		int qte = Clavier.entrerEntier(qst.toString());
		int nqteAchete=acheterProduit(nomVendeur,qte);
		if (nqteAchete==0) {
			System.out.println(nomAcheteur+" veut acheter "+qte+" "+produit+", malheureusement il n’y en a plus !");
		}
		else if (nqteAchete<qte) {
			System.out.println(nomAcheteur+" veut acheter "+qte+" "+produit+",malheureusement "+ nomVendeur +" n’en a plus que "+nqteAchete+". ");
			System.out.println(nomAcheteur+" achète tout le stock de "+nomVendeur + ".");
		}
		else {
			System.out.println(nomAcheteur +" achète "+qte + "  "+produit+ " à "+nomVendeur);
			
		}
		
		
		
	}
	
	public int acheterProduit(String vendeur,int qte) {
		Etal etal=controlTrouverEtalVendeur.trouverEtalVendeur(vendeur);
		return etal.acheterProduit(qte);
	}
	//TODO a completer

	
}
