import java.awt.Color;

import fr.irit.smac.amak.ui.VUI;
import fr.irit.smac.amak.ui.drawables.DrawableCircle;
import fr.irit.smac.amak.ui.drawables.DrawableRectangle;

public class Lumiere extends SourceLumiere {

	private DrawableRectangle drawable;

	public Lumiere(Salle amas) {
		super(amas);
		this.luminosite = 0.0;
		this.nrj = 0.0;
	}

	@Override
	public void augmenterLuminosite() {
		if (this.luminosite >= 100.0) {
			this.luminosite = 100.0;
		} else {
			this.luminosite++;
			this.nrj++;
		}
	}

	@Override
	public void diminuerLuminosite() {
		if (this.luminosite <= 0.0) {
			this.luminosite = 0.0;
		} else {
			this.luminosite--;
			this.nrj--;
		}
	}

	@Override
	protected void onInitialization() {
		this.luminosite = 0.0;
		this.nrj = 0.0;
	}

	@Override
	protected void onRenderingInitialization() {
		drawable = VUI.get().createRectangle(10, 10, 10, 10);
		drawable.setLayer(1);
		//TODO
		double sunlight = 100; //to change
		int tmp = (int) Math.round(255*sunlight/100);
		Color shade = new Color(tmp, tmp, tmp);
		drawable.setColor(shade);
	}

	@Override
	protected void onReady() {
		// TODO Auto-generated method stub

	}

	@Override
	protected double computeCriticality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void onPerceive() {
		// TODO Auto-generated method stub
		// get value of environment luminosity

	}

	@Override
	protected void onDecideAndAct() {
		// TODO Auto-generated method stub
		// depending on luminosty of environment, change light's luminosity

	}

}
