public class Personne {
	private double satisfaction;

	public Personne() {
		this.satisfaction = 50.0;
	}

	public double getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(double luminosite) {
		if (luminosite < 75.0) {// too dark
			this.satisfaction--;
		} else if (luminosite > 75.0 && luminosite < 150.0) {// nice light
			this.satisfaction++;
		} else if (luminosite > 150.0) { // too bright
			this.satisfaction--;
		}
	}

}
