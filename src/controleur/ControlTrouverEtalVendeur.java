package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Etal etal = null;
		Gaulois habitant = village.trouverHabitant(nomVendeur);
		if (habitant != null) {
			etal = village.rechercherEtal(habitant);
		}
		return etal;
	}
}
