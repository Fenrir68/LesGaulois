package objets;

public class Chaudron {
	private int quantitePotion;
	private int forcePostion;
	
	public boolean resterPotion() {
		return quantitePotion>0;
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePostion = forcePotion;
		
	}

	public int prendreLouche() {
		if(--quantitePotion == 0) {
			forcePostion = 0;
		}
		return forcePostion;
	}
}
