package com.ant.companies.controller;

import java.util.HashMap;
import java.util.Map;

import com.ant.companies.model.dao.DaoGeneric;
import com.ant.companies.model.entities.Azienda;
import com.ant.companies.model.entities.Dipendente;
import com.ant.companies.model.entities.Persona;
import com.ant.companies.model.entities.Status;
import com.ant.utility.model.database.Database;
import com.ant.utility.model.database.IDatabase;
import com.ant.utility.model.entities.ConsoleApp;

@Configuration
public class Context {

	@Bean
	public IDatabase db() {
		IDatabase db = new Database("jdbc:mysql://localhost:3306/companies", "root", "root");
		return db;
	}

	private String PATH = "C:\\Users\\Administrator\\curso_java_asti\\companies\\src\\main\\resources\\static\\queries.txt";

	@Bean(name = "query")
	@Primary
	public Map<String, String> query() {
		Map<String, String> mappa = new HashMap<String, String>();
		mappa.putAll(ConsoleApp.readMap(PATH));
		return mappa;
	}

	@Bean
	public DaoGeneric dao() {
		return new DaoGeneric();
	}

	@Bean
	@Scope("prototype") // permette di creare sempre istanze nuove, non oggetti singleton
	// @Primary // specifica che Ã¨ il bean predefinito per creare oggetti
	public Azienda a() {
		return new Azienda();
	}

	@Bean
	@Scope("prototype") // permette di creare sempre istanze nuove, non oggetti singleton
	// @Primary // specifica che Ã¨ il bean predefinito per creare oggetti
	public Dipendente d() {
		return new Dipendente();
	}

	@Bean
	@Scope("prototype") // permette di creare sempre istanze nuove, non oggetti singleton
	// @Primary // specifica che Ã¨ il bean predefinito per creare oggetti
	public Persona pe() {
		return new Persona();
	}

	@Bean
	@Scope("prototype") // permette di creare sempre istanze nuove, non oggetti singleton
	// @Primary // specifica che Ã¨ il bean predefinito per creare oggetti
	public Status st() {
		return new Status();
	}

}
