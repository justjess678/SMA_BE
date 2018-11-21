

public abstract class SourceLumiere{

	protected double luminosite;
	protected double nrj;
	protected Boolean pleinLuminosite;
	protected Boolean minLuminosite;

	public double getLuminosite() {
		return this.luminosite;
	}

	public void setLuminosite(double luminosite) {
		this.luminosite = luminosite;
	}

	public double getNrj() {
		return nrj;
	}

	public void setNrj(double nrj) {
		this.nrj = nrj;
	}

	public Boolean getPleinLuminosite() {
		return pleinLuminosite;
	}

	public Boolean getMinLuminosite() {
		return minLuminosite;
	}

	public void setMinLuminosite(Boolean minLuminosite) {
		this.minLuminosite = minLuminosite;
	}

	public void setPleinLuminosite(Boolean pleinLuminosite) {
		this.pleinLuminosite = pleinLuminosite;
	}

}
