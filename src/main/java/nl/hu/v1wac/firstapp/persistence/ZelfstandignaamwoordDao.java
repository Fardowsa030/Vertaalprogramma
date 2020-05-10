package nl.hu.v1wac.firstapp.persistence;


import java.sql.SQLException;

import nl.hu.v1wac.firstapp.model.Zelfstandignaamwoord;

public interface ZelfstandignaamwoordDao {
	public Zelfstandignaamwoord getZelfstandignaamwoord(String zelfstandignaamwoord);
	public Zelfstandignaamwoord getZelfstandignaamwoordNL(String zelfstandignaamwoord);
	public Zelfstandignaamwoord Save(Zelfstandignaamwoord zelfstandignaamwoord);
	public int createUniqueIDZelfstandignaamwoord();
	public boolean checkZelfstandignaamwoordDatabase(Zelfstandignaamwoord zelfstandignaamwoord) throws SQLException;


}
