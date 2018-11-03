public abstract class SourceLumiere {
	protected float luminosite;
	protected float nrj;

	public float getLuminosite() {
		return luminosite;
	}

	public void setLuminosite(float luminosite) {
		this.luminosite = luminosite;
	}

	public float getNrj() {
		return nrj;
	}

	public void setNrj(float nrj) {
		this.nrj = nrj;
	}

	public abstract void augmenterLuminosite();

	public abstract void diminuerLuminosite();

}
