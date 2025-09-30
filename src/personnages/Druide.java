package personnages;

import objets.Chaudron;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron = new Chaudron();
	
	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + ":";
	}
	
	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté "+ quantite + " doses de potion magique. Elle a une force de " + forcePotion);
	}
	
	public void booster(Gaulois gaulois) {
		boolean contientPotion = chaudron.resterPotion();
		String nomGaulois = gaulois.getNom();
		if(contientPotion) {
			if(nomGaulois == "Obélix") {
				parler("Non " + nomGaulois + "Non!...Et tu le sais très bien !");
			}else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + gaulois + " un peu de potion magique.");
			}
		}else {
			parler("Désolé" + gaulois + " il n'y a plus une seule goutte de potion"); 
		}
		
	}
}
