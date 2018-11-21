public class Lumiere extends SourceLumiere {

	public Lumiere() {
		this.luminosite = 0.0;
		this.nrj = 0.0;
		this.pleinLuminosite = false;
		this.minLuminosite = true;
	}

	public void augmenterLuminosite() {
		if (this.luminosite >= 100.0) {
			this.luminosite = 100.0;
			this.pleinLuminosite = true;
		} else {
			this.luminosite+=5;
			this.nrj += 10;
			if (this.luminosite >= 100.0) {
				this.pleinLuminosite = true;
			}
		}
		this.minLuminosite = false;
	}

	public void diminuerLuminosite() {
		if (this.luminosite <= 0.0) {
			this.luminosite = 0.0;
			this.minLuminosite = true;
		} else {
			this.luminosite-=5;
			this.nrj -= 10;
			if (this.luminosite <= 0) {
				this.minLuminosite = true;
			}
		}
		this.pleinLuminosite = false;
	}

	public void turnOff() {
		this.luminosite = 0;
		this.nrj = 0;
		this.pleinLuminosite = false;
		this.minLuminosite = true;
	}

}
