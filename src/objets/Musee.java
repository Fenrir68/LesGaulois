package objets;

import personnages.Gaulois;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee=0;

	
	public void donnerTrophee(Gaulois gaulois, Trophee trophee) {
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionOCaml() {
		String result="let musee=[\n";
		for(int i=0; i<nbTrophee; i++) {
			Trophee trophee = trophees[i];
			result+="\""+trophee.getGaulois()+"\", \""+trophee.getEquipement().getNom()+"\"";
			if(i+1<nbTrophee) {
				result+=";";
			}
			result+="\n";
		}
		return result+"]";
	}
}
