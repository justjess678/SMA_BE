public class Volet extends SourceLumiere {
	// take into account the level of sunlight
	private float lumSoleil;

	public Volet() {
		this.luminosite = 100.0f;
		this.lumSoleil = 0.0f;
	}

	@Override
	public void augmenterLuminosite() {
		this.nrj++; // accounts for energy required to move the blind
		if (this.luminosite >= 100.0f) {
			this.luminosite = 100.0f;
		} else {
			this.luminosite++;
		}
		this.luminosite = this.luminosite * (this.lumSoleil / 100);
		// wait a bit
		this.nrj--;
	}

	@Override
	public void diminuerLuminosite() {
		this.nrj++; // accounts for energy required to move the blind
		if (this.luminosite <= 0.0f) {
			this.luminosite = 0.0f;
		} else {
			this.luminosite--;
		}
		this.luminosite = this.luminosite * (this.lumSoleil / 100);
		// wait a bit
		this.nrj--;
	}

	public float getLumSoleil() {
		return lumSoleil;
	}

	public void setLumSoleil(float lumSoleil) {
		this.lumSoleil = lumSoleil;
	}

}
