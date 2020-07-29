package com.ant.companies.model.entities;

import com.ant.utility.model.entities.Entity;

public class Azienda extends Entity {

	private String nome;
	private String indirizzo;
	private String tel;
	private String email;

	public Azienda() {
	}

	public Azienda(int id, String nome, String indirizzo, String tel, String email) {
		super(id);
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.tel = tel;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "nome: " + nome + "  \nindirizzo: " + indirizzo + "  \ntel: " + tel + "  \nemail: " + email
				+ "  \ngetId(): " + getId();
	}

}
