package com.ant.companies.model.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.ant.utility.model.database.IDatabase;
import com.ant.utility.model.entities.Entity;
import com.ant.utility.model.entities.SmartList;

public class DaoGeneric {

	@Autowired
	protected IDatabase db;

	@Autowired
	private ApplicationContext context;

	private String READ;

	public DaoGeneric() {
	}

	public String setPercorso(String query) {
		this.READ = query;
		return READ;

	}

	public boolean delete(int id, String query) {
		return db.execute(query, id + "") == -200;

	}

	public List<Entity> list(String query, Class bean) {
		List<Entity> ris = new SmartList<Entity>();

		for (Map<String, String> riga : db.rows(query)) {
			// System.out.print(context == null);
			Entity e = (Entity) context.getBean(bean);
			e.fromMap(riga);
			ris.add(e);
		}
		return ris;
	}

	public Entity load(Entity e, String query) throws NullPointerException {
		Map<String, String> mappa = e.toMap();
		if (query.startsWith("insert")) {
			String chiavi = _StringFromMap(mappa.keySet()).replace("'", "");
			String valori = _StringFromMap(mappa.values());
			String insert = query.replace("[CHIAVI]", chiavi).replace("[VALORI]", valori);
			int ris = db.execute(insert);
			if (ris > 0) {
				e.setId(ris);
				return e;
			}
		} else if (query.startsWith("update")) {
			String modifiche = _StringFromMap(mappa);
			String update = query.replace("[MODIFICHE]", modifiche);
			int ris = db.execute(update, e.getId() + "");
			if (ris == -200)
				return e;
		}

		return null;
	}

	private String _StringFromMap(Collection<String> valori) {
		String ris = "";
		// 'chiavi','chiavi' // 'valori','valori'
		for (String val : valori) {
			String v = val.replace("'", "\\'");
			ris += "'" + v + "',";
		}
		ris = ris.substring(0, ris.length() - 1);
		return ris;
	}

	private String _StringFromMap(Map<String, String> mappa) {
		String ris = "";
		// chiavi='valori',chiavi='valori'
		for (String chiave : mappa.keySet()) {
			String v = mappa.get(chiave).replace("'", "\\'");
			ris += chiave + "='" + v + "',";
		}
		ris = ris.substring(0, ris.length() - 1);
		return ris;
	}

	// Legge in modo univoco
	public Entity search(int id, String query, Class bean) throws NullPointerException {
		for (Entity e : list(query, bean))
			if (e.getId() == id)
				return e;
		return null;
	}

}
