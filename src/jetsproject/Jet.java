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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Jet model: ");
		builder.append(model);
		builder.append("\tspeed: ");
		builder.append(speed);
		builder.append("\trange: ");
		builder.append(range);
		builder.append("\tprice: ");
		builder.append(price);
		builder.append("\tpilot: ");
		builder.append(pilot);
		builder.append("\t");
		return builder.toString();
	}
	
	
	
}
