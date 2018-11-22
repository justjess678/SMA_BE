import fr.irit.smac.amak.Environment;
import fr.irit.smac.amak.Scheduling;

public class MyEnvironment extends Environment {
	
	//the value of luminosity should go in here somewhere
	double luminosity;

	public MyEnvironment(Object...params) {
		super(Scheduling.DEFAULT, params);
		this.luminosity = 100;
		
	}

	public double getLuminosity() {
		return luminosity;
	}

	public void setLuminosity(double luminosity) {
		this.luminosity = luminosity;
	}
	
	
}