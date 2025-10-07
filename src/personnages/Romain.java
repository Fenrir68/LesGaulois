package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	
	public Romain(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:System.out.println("Le soldat " + getNom() + " est déjà bien protégé !");break;
		case 1:
			if(equipements[0] == equipement) {
				System.out.println("Le soldat " + getNom() + " possède déjà un " + equipement);
			}else {
				equiper(equipement, nbEquipement);
			}
			break;
		case 0:
			equiper(equipement, nbEquipement);break;
		default:break;
		}
	}
	
	private void equiper(Equipement e, int i) {
		equipements[i] = e;
		nbEquipement++;
		System.out.println("Le soldat " + getNom() + " s'équipe d'un " + e);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + ":";
	}

	public void recevoirCoup(int force2) {
		assert force2 >= 0;
		int tmp = force;
		force -= force2;
		
		if(force <= 0) {
			parler("J'abandonne");
			force = 0;
		}else {
			parler("Aïe");
		}
		assert isInvariantVerified();
		assert tmp >= force;
	}
	
	private boolean isInvariantVerified() {
		return force >= 0;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);

	}
	
}

