package jetsproject;

public class Pilot {
	
	private String name;
	private int age, experience;
	
	public Pilot() {}
	
	public Pilot(String name, int age, int experience) {
		this.name = name;
		this.age = age;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pilot name: ");
		builder.append(name);
		builder.append("\tage: ");
		builder.append(age);
		builder.append("\texperience:");
		builder.append(experience);
		builder.append("\n");
		return builder.toString();
	}
	
	

}
