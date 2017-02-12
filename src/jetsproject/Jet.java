package jetsproject;

public class Jet {

	private String model;
	private Double speed, range;
	private Double price;
	Pilot pilot;
	
	public Jet() {}
	
	public Jet(String model, Double speed, Double range, Double price, Pilot pilot) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = pilot;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getRange() {
		return range;
	}

	public void setRange(Double range) {
		this.range = range;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nJet model: ");
		builder.append(model);
		builder.append("\tspeed in MPH: ");
		builder.append(speed);
		builder.append("\tspeed in MACH: ");
		builder.append(this.mphToMach());
		builder.append("\trange in mi: ");
		builder.append(range);
		builder.append("\tprice in $: ");
		builder.append(price);
		builder.append("\t");
		builder.append(pilot);
		builder.append("\t");
		return builder.toString();
	}
	
	public int mphToMach() {							// takes the speed of the plane in MPH
		return (int)(this.speed/767.269);				// and converts it to MACH, returned as
	}													// an int
	
}
