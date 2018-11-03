public class Lumiere extends SourceLumiere {

	public Lumiere() {
		this.luminosite = 0.0f;
		this.nrj = 0.0f;
	}

	@Override
	public void augmenterLuminosite() {
		if (this.luminosite >= 100.0f) {
			this.luminosite = 100.0f;
		} else {
			this.luminosite++;
			this.nrj++;
		}
	}

	@Override
	public void diminuerLuminosite() {
		if (this.luminosite <= 0.0f) {
			this.luminosite = 0.0f;
		} else {
			this.luminosite--;
			this.nrj--;
		}
	}

}
