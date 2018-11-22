public class Volet extends SourceLumiere {

	public Volet() {
		this.luminosite = 1;
		this.pleinLuminosite = true;
		this.minLuminosite = false;
	}

	public double augmenterLuminosite() {
		if (this.luminosite >= 1) {
			this.luminosite = 1;
			this.pleinLuminosite = true;
		} else {
			this.luminosite+=0.1;
			if (this.luminosite >= 1) {
				this.pleinLuminosite = true;
			}
		}
		this.minLuminosite = false;
		// returns energy used
		return 10;
	}

	public double diminuerLuminosite() {
		if (this.luminosite <= 0.0) {
			this.luminosite = 0.0;
			this.minLuminosite = true;
		} else {
			this.luminosite-=0.1;
			if(this.luminosite <= 0){
				this.minLuminosite = true;
			}
		}
		this.pleinLuminosite = false;
		return 10;
	}

	public double turnOff() {
		double nrj = 0;
		if (this.luminosite > 0) {
			while (this.luminosite > 0) {
				nrj += this.diminuerLuminosite();
			}
		}
		this.minLuminosite = true;
		return nrj;
	}

}
