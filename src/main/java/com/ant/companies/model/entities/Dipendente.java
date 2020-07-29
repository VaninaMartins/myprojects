package com.ant.companies.model.entities;

import com.ant.utility.model.entities.Entity;

public class Dipendente extends Entity {

	private String mansioneString;
	private int stipendio;

	public Dipendente() {
	}

	public Dipendente(int id, String mansioneString, int stipendio) {
		super(id);
		this.mansioneString = mansioneString;
		this.stipendio = stipendio;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "mansioneString: " + mansioneString + "  \nstipendio: " + stipendio + "  \ngetId(): " + getId();
	}

}
