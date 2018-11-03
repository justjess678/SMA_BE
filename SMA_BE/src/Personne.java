public class Personne {
	private float satisfaction;

	public Personne() {
		this.satisfaction = 50.0f;
	}

	public float getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(float luminosite) {
		if (luminosite < 75.0f) {// too dark
			this.satisfaction--;
		} else if (luminosite > 75.0f && luminosite < 150.0f) {// nice light
			this.satisfaction++;
		} else if (luminosite > 150.0f) { // too bright
			this.satisfaction--;
		}
	}

}
