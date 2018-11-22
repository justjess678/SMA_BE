import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Salle {
	private int SEUIL;
	private int INITIAL_LIGHT_COUNT;
	private int INITIAL_SHUTTER_COUNT;
	private int tick_length;
	private Soleil soleil;
	private int tick;
	private int heure;
	private int jour;
	private int hour_end;
	private int action_prec;
	private double nrj;
	private double luminosite;
	private int satisfaction;
	private int satisfaction_prec;
	private Jours_semaine jourSemaine;
	private ArrayList<Lumiere> lumieres;
	private ArrayList<Volet> volets;
	private boolean tousVoletsOuverts;
	private boolean tousLumieresEteintes;
	private BufferedWriter brightnessWriter;
	private BufferedWriter energyWriter;

	public Salle(int seuil, int initial_light_count, int initial_shutter_count,
			int tick_length) {
		this.SEUIL = seuil;
		this.INITIAL_LIGHT_COUNT = initial_light_count;
		this.INITIAL_SHUTTER_COUNT = initial_shutter_count;
		this.tick_length = tick_length;
		this.soleil = new Soleil();
		this.tousVoletsOuverts = false;
		this.tousLumieresEteintes = false;
		this.tick = 0;
		this.heure = 7;
		this.jour = 0;
		this.hour_end = 18;
		this.action_prec = -1;
		// ironically, one tick is a minute within the environment, but
		// represented by one second
		this.nrj = 0;
		this.luminosite = 0;
		this.satisfaction = 100;
		this.satisfaction_prec = 100;
		this.jourSemaine = Jours_semaine.LUNDI;

		this.lumieres = new ArrayList<Lumiere>();
		this.volets = new ArrayList<Volet>();

		for (int i = 0; i < INITIAL_LIGHT_COUNT; i++)
			lumieres.add(new Lumiere());
		for (int i = 0; i < INITIAL_SHUTTER_COUNT; i++)
			volets.add(new Volet());
		System.out.println("Setup Finished\n");
	}

	public double getLuminosite(ArrayList<Lumiere> lumieres,
			ArrayList<Volet> volets, Soleil soleil) {
		double luminositeLumieres = 0;
		if (lumieres.size() > 0) {
			for (Lumiere l : lumieres) {
				luminositeLumieres += l.getLuminosite();
			}
		}
		double luminositeVolets = 0, temp = 0;
		if (volets.size() > 0) {
			for (Volet v : volets) {
				temp = v.getLuminosite();
				luminositeVolets = luminositeVolets + temp;
			}
		}
		// we assume that the brightness of the shutters is equal to the
		// overall average of their brightness multiplied by the sun's
		// brightness
		luminositeVolets = luminositeVolets / volets.size();

		// update environment brightness
		double luminosite = soleil.getLuminosite() * luminositeVolets
				+ luminositeLumieres;
		return luminosite;
	}

	public void updateTime() {
		// update time/day etc
		if (this.tick == 0) {
			this.heure = (this.heure + 1) % 24;
			if (this.heure == 0) {
				this.jour = (this.jour + 1) % 7;
				switch (this.jour) {
				case 0:
					this.jourSemaine = Jours_semaine.LUNDI;
					System.out.println("Day:\t" + "Monday\n");
					break;
				case 1:
					this.jourSemaine = Jours_semaine.MARDI;
					System.out.println("Day:\t" + "Tuesday\n");
					break;
				case 2:
					this.jourSemaine = Jours_semaine.MERCREDI;
					System.out.println("Day:\t" + "Wednesday\n");
					break;
				case 3:
					this.jourSemaine = Jours_semaine.JEUDI;
					System.out.println("Day:\t" + "Thursday\n");
					break;
				case 4:
					this.jourSemaine = Jours_semaine.VENDREDI;
					System.out.println("Day:\t" + "Friday\n");
					break;
				case 5:
					this.jourSemaine = Jours_semaine.SAMEDI;
					System.out.println("Day:\t" + "Saturday\n");
					break;
				case 6:
					this.jourSemaine = Jours_semaine.DIMANCHE;
					System.out.println("Day:\t" + "Sunday\n");
					break;
				default:
					this.jourSemaine = Jours_semaine.LUNDI;
					System.out.println("Day:\t" + "Monday\n");
					break;
				}
			}
			// days where people work late are monday, tuesday and wednesday
			// (arbitrary)
			if (this.jourSemaine == Jours_semaine.LUNDI
					|| this.jourSemaine == Jours_semaine.MARDI
					|| this.jourSemaine == Jours_semaine.MERCREDI) {
				this.hour_end = 21;
			} else {
				this.hour_end = 18;
			}
			System.out.println("Today the workday ends at " + this.hour_end
					+ "h\n");
		}
	}

	public String getTime() {
		String s = "";
		if (this.tick < 10) {
			s = "Time:\t" + this.heure + "h0" + this.tick;
		} else {
			s = "Time:\t" + this.heure + "h" + this.tick;
		}
		return s;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}
	
	public double getSun(){
		return this.soleil.getLuminosite();
	}

	public void update() {
		this.updateTime();
		System.out.println(this.getTime());
		this.nrj = 0;
		// we don't work on weekends
		if (jourSemaine != Jours_semaine.SAMEDI
				&& jourSemaine != Jours_semaine.DIMANCHE) {
			luminosite = 0;
			soleil.update(heure,tick);

			luminosite = getLuminosite(lumieres, volets, soleil);
			System.out.println("Current brightness:\t" + luminosite + "\n");

			if (heure < hour_end) {
				if (luminosite < SEUIL - 5 && satisfaction > 75) {
					tousVoletsOuverts = true;
					for (Volet v : volets) {
						if (!v.getPleinLuminosite()) {
							nrj += v.augmenterLuminosite();
							tousVoletsOuverts = false;
						}
					}
					if (tousVoletsOuverts) {
						// we're going to have to switch on the lights
						for (Lumiere l : lumieres) {
							if (!l.getPleinLuminosite()) {
								l.augmenterLuminosite();
							}
						}
					}
				} else if (luminosite > SEUIL + 5 && satisfaction > 75) {
					// to save energy we won't make the room brighter than
					// necessary
					tousLumieresEteintes = true;
					for (Lumiere l : lumieres) {
						if (!l.getMinLuminosite()) {
							l.diminuerLuminosite();
							tousLumieresEteintes = false;
						}
					}
					if (tousLumieresEteintes) {
						// we're going to have to close the shutters
						for (Volet v : volets) {
							if (!v.getMinLuminosite()) {
								v.diminuerLuminosite();
							}
						}
					}
				} else {
					// users satisfaction now drives the changes
					if (satisfaction < satisfaction_prec) {
						// users are less happy during this tick
						if (action_prec == 0) {
							// if the last thing we did was lower brightness
							// we should raise it some
							tousVoletsOuverts = true;
							for (Volet v : volets) {
								if (!v.getPleinLuminosite()) {
									nrj += v.augmenterLuminosite();
									tousVoletsOuverts = false;
								}
							}
							if (tousVoletsOuverts) {
								// we're going to have to switch on the
								// lights
								for (Lumiere l : lumieres) {
									if (!l.getPleinLuminosite()) {
										l.augmenterLuminosite();
									}
								}
							}
							action_prec = 1;
						} else if (action_prec == 1) {
							// if the last thing we did was raise brightness
							// we should lower it some
							tousLumieresEteintes = true;
							for (Lumiere l : lumieres) {
								if (!l.getMinLuminosite()) {
									l.diminuerLuminosite();
									tousLumieresEteintes = false;
								}
							}
							if (tousLumieresEteintes) {
								// we're going to have to close the shutters
								for (Volet v : volets) {
									if (!v.getMinLuminosite()) {
										v.diminuerLuminosite();
									}
								}
							}
							action_prec = 0;
						}

					}
				}
				// calculate new brightness
				luminosite = getLuminosite(lumieres, volets, soleil);
				for (Lumiere l : lumieres) {
					nrj += l.getNrj();
				}
				satisfaction_prec = satisfaction;
			}
		} else {
			// make sure everything is turned off to save power
			// and the shutters are closed for security reasons
			for (Lumiere l : lumieres) {
				l.turnOff();
			}
			for (Volet v : volets) {
				nrj += v.turnOff();
			}
		}
		System.out.println("\nBrightness:\t" + luminosite + "\nEnergy used:\t"
				+ nrj + " watts\nShutters are " + volets.get(0).getLuminosite()
				* 100 + "% open\nLights are at "
				+ lumieres.get(0).getLuminosite() + "% brightness\n");
		try {
			this.brightnessWriter = new BufferedWriter(new FileWriter(
					"brightness.txt", false));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			this.energyWriter = new BufferedWriter(new FileWriter("energy.txt",
					false));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// writing values to file to exploit later
		try {
			brightnessWriter.append(getTick() + "\t" + luminosite + "\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			energyWriter.append(getTick() + "\t" + nrj + "\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			brightnessWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			energyWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tick = (tick + 1) % 60;
		try {
			TimeUnit.SECONDS.sleep(tick_length);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		// close files
		try {
			brightnessWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			energyWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getTick_length() {
		return tick_length;
	}

	public int getTick() {
		return tick;
	}

	public double getNrj() {
		return nrj;
	}

	public double getLuminosite() {
		return luminosite;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public int getSatisfaction_prec() {
		return satisfaction_prec;
	}

	public Jours_semaine getJourSemaine() {
		return jourSemaine;
	}

	public ArrayList<Lumiere> getLumieres() {
		return lumieres;
	}

	public ArrayList<Volet> getVolets() {
		return volets;
	}

	public static void main(String[] args) {
		Salle salle = new Salle(70, 1, 1, 1);
		while (true) {
			salle.update();
		}

	}

}
