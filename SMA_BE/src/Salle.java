import java.util.ArrayList;

import fr.irit.smac.amak.*;
import fr.irit.smac.amak.ui.MainWindow;

public class Salle extends Amas<MyEnvironment> {

	private static final int INITIAL_LIGHT_COUNT = 1;
	private static final int INITIAL_SHUTTER_COUNT = 1;
	private ArrayList<Lumiere> lumieres = new ArrayList<Lumiere>();
	private ArrayList<Volet> volets = new ArrayList<Volet>();

	public Salle(MyEnvironment env) {
		// Set the environment and use default scheduling
		super(env, Scheduling.DEFAULT);
	}

	@Override
	protected void onInitialAgentsCreation() {
		for (int i = 0; i < INITIAL_LIGHT_COUNT; i++)
			this.lumieres.add(new Lumiere(this));
		for (int i = 0; i < INITIAL_SHUTTER_COUNT; i++)
			this.volets.add(new Volet(this));
	}

	protected void removeLight() {
		this.lumieres.remove(this.lumieres.size());
	}

	protected void removeShutter() {
		this.volets.remove(this.volets.size());
	}

	protected void addLight() {
		this.lumieres.add(new Lumiere(this));
	}

	protected void addShutter() {
		this.volets.add(new Volet(this));
	}

	public static void main(String[] args) {

		Salle salle = new Salle(new MyEnvironment());

		new DrawableUI<Salle>(salle);
		MainWindow.addMenuItem("Remove 1 light", l -> {l.removeLight()});
		MainWindow.addMenuItem("Add 1 light", l -> {l.addLight()});
		MainWindow.addMenuItem("Remove 1 shutter", l -> {salle.removeShutter()});
		MainWindow.addMenuItem("Add 1 shutter", l -> {salle.addShutter()});

	}

	@Override
	protected void onSystemCycleEnd() {
		// code that must be executed at the end of each cycle
		// For example, draw a point on a chart
		// Update physical representation of light/shutter
		// Update everything. Like, EVERYTHING

	}

}
