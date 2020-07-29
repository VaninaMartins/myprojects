package com.ant.companies.model.entities;

import com.ant.utility.model.entities.Entity;

public class Status extends Entity {

	private String descrizione;

	public Status() {
	}

	public Status(int id, String descrizione) {
		super(id);
		this.descrizione = descrizione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "descrizione: " + descrizione + "  \ngetId(): " + getId();
	}

}
