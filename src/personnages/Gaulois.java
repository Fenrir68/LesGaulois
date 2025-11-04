package personnages;
import objets.Equipement;
import objets.Musee;
import objets.Trophee;

public class Gaulois {
	private String nom;
	private Village village = null;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees=0;
	private Equipement[] trophees = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setVillage(Village village) {
		this.village = village;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void sePresenter() {
		if(village == null) {
			parler("Bonjour, je m'appelle Doublepolémix. Je voyage de villages en villages.");
		}else {
			if(village.getChef() == this) {
				parler("Bonjour, je m'appelle " + getNom() + ". Je suis le chef du village " + village.getNom() + ".");
			}else {
				parler("Bonjour, je m'appelle" + getNom() + ". J'habite le village " + village.getNom() + ".");
			}
		}
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);
	}

	@Override
	public String toString() {
		return nom;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesBataille = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesBataille != null && i<tropheesBataille.length; i++,
		nbTrophees++) {
			this.trophees[nbTrophees] = tropheesBataille[i];
			}
		}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}
	
	public void faireUneDonation(Musee musee) {
		if(nbTrophees>0) {
			String don="";
			for(int i=0; i<nbTrophees; i++) {
				Equipement equip = trophees[i];
				musee.donnerTrophee(this, new Trophee(this, equip));
				don+="\n-"+equip.getNom();
			}
			parler("Je donne au musée tous mes trophées :"+don);
			nbTrophees=0;
		}
	}
	
}
