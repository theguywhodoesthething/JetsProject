package jetsproject;

public class Hangar {

	Jet[] jets = new Jet[JetsProjectMain.CAPACITY];
	
	public Hangar() {}

	public Hangar(Jet[] jets) {
		this.jets = jets;
	}

	public Jet[] getJets() {
		return jets;
	}

	public void setJets(Jet[] jets) {
		this.jets = jets;
	}
	
	public Hangar addJet(Jet jet) {						// finds the first empty slot in the Hangar 
		for (int i = 0; i < this.jets.length; i++) {	// and assigns the new jet to this slot.
			if (this.jets[i] == null) {					// returns the updated hangar
				this.jets[i] = jet;
				break;
			}
		}
		return this;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hangar\n");
		for (Jet i : jets) {
			if (i != null) {
				builder.append(i.toString());
			}
			else { break; }
		}
		return builder.toString();
	}

}
