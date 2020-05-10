package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;

import nl.hu.v1wac.firstapp.model.Engels;

public interface EngelsDao {
	public Engels getEngels(String zin) throws SQLException;
	public String checkCharacters(String zin);

}
