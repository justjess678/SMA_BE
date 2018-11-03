import java.util.ArrayList;

public class Salle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numOfLum = 1;
		int numOfVol = 1;
		int numOfPers = 1;
		float THRESHOLD_LOW = 75;

		Float soleil = 100.0f;
		float lumTotal = 0.0f;
		float nrjTotal = 0.0f;
		Boolean stop = false;
		int heure = 0;
		int jour = 0; // lundi

		ArrayList<Lumiere> lumieres = new ArrayList<Lumiere>();
		ArrayList<Volet> volets = new ArrayList<Volet>();
		ArrayList<Personne> personnes = new ArrayList<Personne>();

		for (int i = 0; i < numOfLum; i++) {
			lumieres.add(new Lumiere());
		}
		for (int i = 0; i < numOfVol; i++) {
			volets.add(new Volet());
		}
		for (int i = 0; i < numOfPers; i++) {
			personnes.add(new Personne());
		}

		while (!stop) {
			jour++;
			jour = jour % 7;
			heure++;
			heure = heure % 24;
			if (heure >= 8 && heure <= 21) {
				// sun is active, peaks at 12
				if (heure != 12) {
					float tmp = Math.abs(12 - heure);
					soleil = (1.0f / tmp) * 90.0f;
				} else {
					soleil = 100.0f;
				}
				// Simulation capteur luminosite
				lumTotal = Math.round(lumieres.get(0).getLuminosite()
						+ (volets.get(0).getLuminosite() * (soleil / 100)));
				// Simulation capteur energie
				nrjTotal = lumieres.get(0).getNrj() + volets.get(0).getNrj();

				System.out.println("Luminosite: " + lumTotal
						+ "\nEnergie consommee: " + nrjTotal);

				for (int i = 0; i < numOfPers; i++) {
					personnes.get(i).setSatisfaction(lumTotal);
				}
			} else {
				// sun is inactive
				soleil = 0.0f;
				//turn off devices
				for(int i=0;i<numOfLum;i++){
					lumieres.get(i).setLuminosite(0.0f);
				}
				for(int i=0;i<numOfVol;i++){
					lumieres.get(i).setLuminosite(0.0f);
				}
				System.out.println("NUIT");
			}
		}

	}
}
