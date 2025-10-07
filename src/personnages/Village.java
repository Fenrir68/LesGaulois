package personnages;

public class Village{

	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private final int NB_VILLAGEOIS_MAX;
	private Gaulois[] villageois;
	
	public Village(String nom, Gaulois chef, final int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.NB_VILLAGEOIS_MAX = NB_VILLAGEOIS_MAX;
		this.chef = chef;
		chef.setVillage(this);
		villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < NB_VILLAGEOIS_MAX) {
			villageois[nbVillageois] = gaulois;
			nbVillageois ++;
			gaulois.setVillage(this);
		}
	}
	
	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= nbVillageois) {
			return villageois[numVillageois-1];
		}else {
			System.out.println("Il n'y a pas autant de villageois dans notre village !");
			return null;
		}
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village \"" + getNom() + "\" du chef " + getChef().getNom() + " vivent les légendaires gaulois :");
		for(int i=1; i<=nbVillageois; i++) {
			System.out.println("-" + trouverVillageois(i).getNom());
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles",abraracourix, 30);
		//Gaulois gaulois = village.trouverVillageois(30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);
		village.afficherVillage();
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
