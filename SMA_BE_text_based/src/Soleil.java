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

	public void update(int heure) {
		if (heure > 21 || heure < 8) {
			// night time
			this.luminosite = 0;
		} else if (heure == 12) {
			this.luminosite = 100;
		} else if (heure == 11) {
			this.luminosite = 80;
		} else if (heure == 10) {
			this.luminosite = 60;
		} else if (heure == 9) {
			this.luminosite = 40;
		} else if (heure == 8) {
			this.luminosite = 20;
		} else if (heure == 13) {
			this.luminosite = 88.9;
		} else if (heure == 14) {
			this.luminosite = 77.8;
		} else if (heure == 15) {
			this.luminosite = 66.7;
		} else if (heure == 16) {
			this.luminosite = 55.6;
		} else if (heure == 17) {
			this.luminosite = 44.5;
		} else if (heure == 18) {
			this.luminosite = 33.4;
		} else if (heure == 19) {
			this.luminosite = 22.3;
		} else if (heure == 20) {
			this.luminosite = 11.1;
		}
	}
}
