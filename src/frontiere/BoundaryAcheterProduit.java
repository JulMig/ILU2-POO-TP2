package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Vous n'êtes pas du village! Vous ne pouvez pas acheter ici.");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			
			String[] vendeurs = controlAcheterProduit.chercherVendeursProduit(produit);
			
			if (vendeurs == null) {
				System.out.println("Personne ne vend de ça ici.");
			} else {
				System.out.println("Chez quel commerçant voulez-vous acheter des fleurs ?");
				for(int i = 0; i < vendeurs.length; i++) {
					System.out.println((i+1) + " - " + vendeurs[i]);
				}
				
				int i = 0;
				
				do {
					i = Clavier.entrerEntier("");
				} while (i <= 0 || i > vendeurs.length);
				
				String vendeur = vendeurs[i-1];
				
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeur +
						"\nBonjour " + nomAcheteur);
				
				int quantite;
				do {
					quantite = Clavier.entrerEntier("Combien de fleurs voulez-vous acheter?");
				} while (quantite < 0);
				
				int quantiteAcheter = controlAcheterProduit.acheterProduit(vendeur, quantite);
				System.out.println(nomAcheteur + " a acheté " + quantiteAcheter + " de " + produit + " à " + vendeur);
			}
			
		}
	}
}
