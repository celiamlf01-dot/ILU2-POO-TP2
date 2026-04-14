package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		//TODO a completer
		if(!(controlLibererEtal.isVendeur(nomVendeur))) {
			System.out.println("Mais vous n'êtes pas inscrit sur\r\n"
					+ "notre marché aujourd'hui !");
		}else {
			String donneesEtal[]=controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe=donneesEtal[0];
			if(etalOccupe.equals("true"))
			{
				System.out.println("Vous avez vendu "+donneesEtal[4]+ "sur"+donneesEtal[3]+donneesEtal[2]+" s.\r\n"
						+ "");
				System.out.println("En revoir "+nomVendeur+", passez une bonne\r\n"
						+ "journée.\r\n"
						+ "");
			}
		}
	}

}
