package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1wac.firstapp.model.Lidwoord;

public class LidwoordDaoImpl extends OracleBaseDao implements LidwoordDao {
	
	private Connection conn;

    public LidwoordDaoImpl() {
        try {
            conn = super.getConnection();
        } catch (SQLException e) {
            System.out.println("Error: could not connect to database.");
            e.printStackTrace();
        }
    }
	
    @Override
	public Lidwoord getLidwoord(String lidwoord) {
    	
        try {
            String queryText =  "SELECT ENGELS " +
                    "FROM LIDWOORD " +
                    "WHERE lidwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,lidwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            String lidwoord_engels = result.getString("ENGELS");

            System.out.println(lidwoord_engels);

            return new Lidwoord(lidwoord_engels);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public Lidwoord getLidwoordNL(String lidwoord) {
    	
        try {
            String queryText =  "SELECT LIDWOORD " +
                    "FROM LIDWOORD " +
                    "WHERE lidwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,lidwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            String lidwoord_nederlands = result.getString("LIDWOORD");

            System.out.println(lidwoord_nederlands);

            return new Lidwoord(lidwoord_nederlands);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
	 public int createUniqueID() {

	        try {
	            String queryText =  "SELECT MAX(ID) + 1 as newID " +
	                    "FROM LIDWOORD";

	            PreparedStatement stmt = conn.prepareStatement(queryText);

	            ResultSet result = stmt.executeQuery();

	            result.next();

	            int id = result.getInt("newID");
	            System.out.println(id);
	            return id;
	        }
	        catch(SQLException e) {
	            e.printStackTrace();
	            return 0;
	        }
	    }


	public Lidwoord save(Lidwoord lidwoord) {
		try (Connection con = getConnection()) {
			Statement stmt = con.createStatement();
			int uniek  = createUniqueID();
			
			String query = "INSERT INTO lidwoord (id, lidwoord)VALUES('" + uniek + "', '"+
					lidwoord.getLidwoord() + "')";
			
			stmt.executeUpdate(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return lidwoord;		
		
	}
	

	public boolean checkLidwoordDatabase(Lidwoord lidwoord) throws SQLException {
		
			boolean resultaat;
            String queryText =  "SELECT lidwoord " +
                    "FROM LIDWOORD " +
                    "WHERE lidwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,lidwoord.getLidwoord());
            ResultSet result = stmt.executeQuery();

            if(result.next()) {
            	resultaat = true;
            }
            else {
            	resultaat = false;
            }
            return resultaat;
            
            }
          
            
            

	

	
	
}
