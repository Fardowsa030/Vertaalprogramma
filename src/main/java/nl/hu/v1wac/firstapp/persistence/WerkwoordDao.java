package nl.hu.v1wac.firstapp.persistence;

import java.sql.SQLException;
import nl.hu.v1wac.firstapp.model.Werkwoord;

public interface WerkwoordDao {
	
	public Werkwoord getWerkwoord(String werkwoord);
	public Werkwoord getWerkwoordNL(String werkwoord);
	public Werkwoord Save(Werkwoord werkwoord);
	public int createUniqueIDWerkwoord();
	public boolean checkWerkwoordDatabase(Werkwoord werkwoord) throws SQLException;

	

}
