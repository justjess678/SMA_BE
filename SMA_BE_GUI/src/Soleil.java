public class Soleil {
	private double luminosite;

	public Soleil() {
		this.luminosite = 0;
	}

	public double getLuminosite() {
		return this.luminosite;
	}

	public void setLuminosite(double luminosite) {
		this.luminosite = luminosite;
	}

	public void update(int heure, int minutes) {
		if (heure > 21 || heure < 8) {
			// night time
			this.luminosite = 0;
		} else {
			double time = (heure + minutes * 0.01 / 0.6);
			this.luminosite = Math.round(time * (100 / 12)
					* (12 - Math.abs(time - 12)) / 11.52);
		}
		System.out.println("Sun:" + this.luminosite);
	}
}
