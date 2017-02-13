package jetsproject;

import java.util.Scanner;

public class JetsProjectMain {
	
	private static Scanner kb = new Scanner(System.in);
																					// CAPACITY = the size of the
	private static Hangar hangar = new Hangar();									// array that holds the pilots
	private static Barracks barracks = new Barracks();								// and jets, for a bigger
																					// barracks or hangar use a
	public static final int CAPACITY = 100;											// bigger number
																					
	public static void main(String[] args) {										
	
		init();																		// Initializes the hangar
																					// and the barracks
		char selection;																
		
		System.out.println("\nWelcome to the Jets Program. What would you like to do?");

		while (true) {

			System.out.println("\n1: List jets\n2: Show fastest jet\n3: Show longest range jet\n4: Add jet to the hanger\n"
								+ "5: List pilots\n6: Hire pilot\n7: Assign pilot\nEnter Q to Quit");
			selection = kb.next().toLowerCase().charAt(0);
			
			switch(selection) {
				case '1': System.out.println(hangar.toString());
					break;
				case '2': System.out.println(fastJet().toString());
					break;
				case '3': System.out.println(longJet().toString());
					break;
				case '4': newJet();
					break;
				case '5': System.out.println(barracks.toString());
					break;
				case '6': newPilot();
					break;
				case '7': assignPilot();
					break;
				case 'q': kb.close();
					return;
				default: System.out.println("I don't understand that selection. Please try again.");		
			}
		}
	}
	
	private static void init() {
	
		int c = 0, p = 0;																
		
		Pilot[] pilotArray = new Pilot[CAPACITY];
		pilotArray[c++] = new Pilot("Bart Simpson", 13, 6);							// assign the first 5
		pilotArray[c++] = new Pilot("Walter White", 42, 8);							// spots in the pilot array
		pilotArray[c++] = new Pilot("Elizabeth White", 86, 54);						// and a default for the
		pilotArray[c++] = new Pilot("Harold Jones", 25, 1);							// last array position
		pilotArray[c++] = new Pilot("Bender Rodridguez", 33, 3);
		pilotArray[CAPACITY-1] = new Pilot("none assigned", 0, 0);
		
		c = 0;
		
		Jet[] jetArray = new Jet[CAPACITY];
		jetArray[c++] = new Jet("Spider", 300.0, 3300.0, 6e6, pilotArray[p++]);		// assign the first 5
		jetArray[c++] = new Jet("Duckie", 200.0, 7200.0, 5e6, pilotArray[p++]);		// jets and assigns the
		jetArray[c++] = new Jet("Weasel", 350.0, 6100.0, 2e6, pilotArray[p++]);		// first 5 pilots to those
		jetArray[c++] = new Jet("Warthog", 1150.0, 5500.0, 1e6, pilotArray[p++]);	// jets
		jetArray[c++] = new Jet("B-52 LS", 280.0, 21100.0, 6e6, pilotArray[p++]);
		
		hangar = new Hangar(jetArray);
		barracks = new Barracks(pilotArray);
		
	}
	
	public static Jet fastJet() {						// finds and returns the fastest
		Jet fast = null;								// jet in the hangar
		double big = Double.MIN_VALUE;
		
		for (Jet i : hangar.getJets()) {
			if (i == null) {
				break;
			}	
			else if (i.getSpeed() > big) {
				fast = i;
				big = i.getSpeed();
			}
		}
		return fast;
	}
	
	public static Jet longJet() {						// finds and returns the longest
		Jet range = null;								// range jet in the hangar
		double big = Double.MIN_VALUE;
		
		for (Jet i : hangar.getJets()) {
			if (i == null) {
				break;
			}	
			else if (i.getRange() > big) {
				range = i;
				big = i.getRange();
			}
		}
		return range;
	}
	
	public static void newJet() {

		Jet newJet = new Jet();
		
		kb.nextLine();
		System.out.println("Please enter the model of your new jet.");
		newJet.setModel(kb.nextLine());
		System.out.println("Please enter the speed of your new jet in MPH.");
		newJet.setSpeed(kb.nextDouble());
		System.out.println("Please enter the range of your new jet in mi.");
		newJet.setRange(kb.nextDouble());
		System.out.println("Please enter the price of your new jet in $.");
		newJet.setPrice(kb.nextDouble());
		
		newJet.setPilot(barracks.getPilots()[CAPACITY-1]);
		
		hangar.addJet(newJet);

		System.out.println("Your new jet has been added to your hangar");
	}
	
	public static void newPilot() {
		
		Pilot newPilot = new Pilot();
		
		kb.nextLine();
		System.out.println("Please enter the name of your new pilot.");
		newPilot.setName(kb.nextLine());
		System.out.println("Please enter the age of your new pilot.");
		newPilot.setAge(kb.nextInt());
		System.out.println("Please enter the experience of your new pilot in y.");
		newPilot.setExperience(kb.nextInt());
		
		barracks.hirePilot(newPilot);
		
		System.out.println("Your new pilot has been added to the barracks.");
	}
	
	public static void assignPilot() {							// allows the user to reassign
																// any pilot that already exits
		String newPilotName;									// in the barracks to any jet
		String pilotsNewJetName;								// that already exists in the
		Pilot pilotToReassign = null;							// hangar
		Jet jetToReassign = null;
		

		kb.nextLine();
		System.out.println("Please enter the name of the pilot you would like to reassign.");
		newPilotName = kb.nextLine();
		
		for (Pilot i : barracks.getPilots()) {
			if (i != null && i.getName().equals(newPilotName)) {
				pilotToReassign = i;
				break;
			} else if (i == null) {
				System.out.println("That pilot doesn't exist. Please hire this pilot first.");
				return;
			}
		}
		
		System.out.println("Please enter the name of the jet you would like to assign this pilot to.");
		pilotsNewJetName = kb.nextLine();
		
		for (Jet i : hangar.getJets()) {
			if (i != null && i.getModel().equals(pilotsNewJetName)) {
				jetToReassign = i;
				break;
			} else if (i == null) {
				System.out.println("That jet doesn't exist. Please add this jet first.");
				return;
			}
		}
		
		for(Jet i : hangar.getJets()) {
			if ( i == jetToReassign) {
				for(Pilot j : barracks.getPilots()) {
					if ( j == pilotToReassign) {
						i.setPilot(j);
						break;
					}
				}
				break;
			}
		}

		System.out.println("Your pilot " + pilotToReassign.getName() + " has been reassigned to "
							+ jetToReassign.getModel());
	}

}
