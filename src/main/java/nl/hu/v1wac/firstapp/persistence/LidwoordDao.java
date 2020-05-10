package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;

import nl.hu.v1wac.firstapp.model.Lidwoord;

public interface LidwoordDao {
	public Lidwoord getLidwoord(String lidwoord);
	public Lidwoord getLidwoordNL(String lidwoord);
	public Lidwoord save(Lidwoord lidwoord);
	public int createUniqueID();
	public boolean checkLidwoordDatabase(Lidwoord lidwoord) throws SQLException;

}
