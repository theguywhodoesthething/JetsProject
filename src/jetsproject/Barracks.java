package jetsproject;

public class Barracks {
	
	private Pilot[] pilots = new Pilot[100];
	
	public Barracks() {}

	public Barracks(Pilot[] pilots) {
		this.pilots = pilots;
	}

	public Pilot[] getPilots() {
		return pilots;
	}

	public void setPilots(Pilot[] pilots) {
		this.pilots = pilots;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Barracks\n");
		for (Pilot i : pilots) {
			if (i != null) {
				builder.append(i.toString());
			}
			else { break; }
		}
		return builder.toString();
	}

	public Barracks hirePilot(Pilot pilot) {				// finds the first empty slot in the Barracks 
		for (int i = 0; i < this.pilots.length; i++) {		// and assigns the new pilot to this slot.
			if (this.pilots[i] == null) {					// returns the updated Barracks
				this.pilots[i] = pilot;
				break;
			}
		}
		return this;
	}

}
