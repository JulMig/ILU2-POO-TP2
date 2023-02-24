package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)) {
			
			System.out.println("Bonjour " + nomVendeur + " je vais regarder si je peux vous trouver un étal.\n");
			
			if (!controlPrendreEtal.resteEtals()) {
				
				System.out.println("Désolée " + nomVendeur + " je n'ai plus d'étal qui ne soit déjà occupé.\n");
				
			} else {
				
				System.out.println("C'est parfait, il me reste un étal pour vous !\n"
						+ "Il me faudrait quelques renseignements :\n"
						+ "Quel produit souhaitez-vous vendre ?");
				String produit = scan.next();
				int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
			
				int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
				
				if (numeroEtal != -1) {
					System.out.println("Le vendeur " + nomVendeur + "s'est installé à l'étal n°" + numeroEtal);
				} 
			}
		} else {
			System.out.println("Je suis désolé " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
