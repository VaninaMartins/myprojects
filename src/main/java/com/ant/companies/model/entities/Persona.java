package com.ant.companies.model.entities;

import com.ant.utility.model.entities.Entity;
import com.mysql.fabric.xmlrpc.base.Data;

public class Persona extends Entity {

	private String nome;
	private String cognome;
	private Data datanascita;
	private int idstatus;
	
	public Persona () {
	}

	public Persona(int id, String nome, String cognome, Data datanascita, int idstatus) {
		super(id);
		this.nome = nome;
		this.cognome = cognome;
		this.datanascita = datanascita;
		this.idstatus = idstatus;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Data getDatanascita() {
		return datanascita;
	}

	public void setDatanascita(Data datanascita) {
		this.datanascita = datanascita;
	}

	public int getIdstatus() {
		return idstatus;
	}

	public void setIdstatus(int idstatus) {
		this.idstatus = idstatus;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "id:" + getId() + "nome: " + nome + "  \ncognome: " + cognome + "  \ndatanascita: " + datanascita + "  \nidstatus: "
				+ idstatus;
	}

}
