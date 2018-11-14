import fr.irit.smac.amak.Agent;

public abstract class SourceLumiere extends Agent<Salle, MyEnvironment> {

	public SourceLumiere(Salle amas) {
		super(amas);

	}

	@Override
	protected abstract void onInitialization();

	@Override
	protected abstract void onReady();

	@Override
	protected abstract double computeCriticality();

	protected abstract void onPerceive();

	protected abstract void onDecideAndAct();

	protected double luminosite;
	protected double nrj;

	public double getLuminosite() {
		return luminosite;
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

	public abstract void augmenterLuminosite();

	public abstract void diminuerLuminosite();

}
