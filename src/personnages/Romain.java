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
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if(force>0) {
		parler("Aïe");
		}else {
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		}
		return equipementEjecte;
		}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de" + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;i++) {
		if (equipements[i] != null) {
			if(equipements[i].equals(Equipement.BOUCLIER)){
				resistanceEquipement += 8;
			}else {
				System.out.println("Equipement casque");
				resistanceEquipement += 5;
				}
			}
		}
		texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup = resistanceEquipement>forceCoup ? 0 : forceCoup-resistanceEquipement;
		return forceCoup;
		}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");

		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipements[i] != null) {
		equipementEjecte[nbEquipementEjecte] = equipements[i];
		nbEquipementEjecte++;
		equipements[i] = null;
		}
		}
		return equipementEjecte;
		}
		
	public int getForce() {
		return force;
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

