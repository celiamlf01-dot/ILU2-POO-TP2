package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					//TODO a completer
					 System.out.println("Bienvenue Villageois " + nomVisiteur + ", quelle est votre force ?");
					 int forceGaulois= Clavier.entrerEntier("");
					 controlEmmenager.ajouterGaulois(nomVisiteur, forceGaulois);
					    
					    

					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {

	    System.out.println("Bienvenue druide " + nomVisiteur + ", quelle est votre force ?");
	    int forceDruide = Clavier.entrerEntier("");

	    int effetPotionMin, effetPotionMax;

	    do {
	        System.out.println("Quelle est la force de potion la plus faible ?");
	        effetPotionMin = Clavier.entrerEntier("");

	        System.out.println("Quelle est la force de potion la plus forte ?");
	        effetPotionMax = Clavier.entrerEntier("");
	        if(effetPotionMax<effetPotionMin)
	        {
	        	 System.out.println("attention Druide , vous vous etes trompe entre le min et max");
	        }

	    } while (effetPotionMin > effetPotionMax);
	    controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	   
	}
	}
}
