package com.ant.companies.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.ant.companies.model.dao.DaoGeneric;
import com.ant.companies.model.entities.Azienda;
import com.ant.companies.model.entities.Dipendente;
import com.ant.companies.model.entities.Persona;
import com.ant.companies.model.entities.Status;
import com.ant.utility.model.database.Database;
import com.ant.utility.model.database.IDatabase;
import com.ant.utility.model.entities.ConsoleApp;


@Configuration
public class Context 
{
	
	
	@Bean
	public IDatabase db()
	{
		IDatabase db = new Database("jdbc:mysql://localhost:3306/companies","root","root");
		return db;
	}

    private String PATH= "C:\\Users\\Zaza\\eclipse-workspace2\\companies\\src\\main\\resources\\static\\queries.txt";
    
	@Bean(name = "query")
	@Primary
	public Map<String, String> query()
	{
		Map<String, String> mappa = new HashMap<String,String>();
		mappa.putAll(ConsoleApp.readMap(PATH));
		return mappa;
	}
	
	
	@Bean
	public DaoGeneric dao()
	{
		return new DaoGeneric();
	}
	
	@Bean
	@Scope("prototype")	
	// permette di creare sempre istanze nuove, non oggetti singleton
	//@Primary // specifica che Ã¨ il bean predefinito per creare oggetto
	public Azienda azienda()
	{
		return new Azienda();
	}

	@Bean
	@Scope("prototype")	
	public Dipendente dipendente()
	{
		return new Dipendente();
	}

	@Bean
	@Scope("prototype")	
	public Persona persona()
	{
		return new Persona();
	}
	
	@Bean
	@Scope("prototype")	
	public Status status()
	{
		return new Status();
	}
	
}
