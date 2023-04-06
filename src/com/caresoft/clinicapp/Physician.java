package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
//... imports class definition...

	// Inside class:
	private ArrayList<String> patientNotes;

	// TO DO: Constructor that takes an ID
	public Physician(Integer id) {
		super(id);
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}

	// TO DO: Implement HIPAACompliantUser!
	@Override
	public boolean assignPin(int pin) {

		// find the how many digits pin is
		double numberOfDigits = Math.floor(Math.log10(pin) + 1);

		if (numberOfDigits != 4.0) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// return if the given id is a match
		return this.id == confirmedAuthID;
	}


	// TO DO: Setters & Getters
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

}
