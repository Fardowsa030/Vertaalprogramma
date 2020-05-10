package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1wac.firstapp.model.Werkwoord;
import nl.hu.v1wac.firstapp.model.Zelfstandignaamwoord;

public class ZelfstandignaamwoordDaoImpl extends OracleBaseDao implements ZelfstandignaamwoordDao {
	
	private Connection conn;

    public ZelfstandignaamwoordDaoImpl() {
        try {
            conn = super.getConnection();
        } catch (SQLException e) {
            System.out.println("Error: could not connect to database.");
            e.printStackTrace();
        }
    }
	
    public Zelfstandignaamwoord getZelfstandignaamwoord(String zelfstandignaamwoord) {
    	

        try {
            String queryText =  "SELECT ENGELS " +
                    "FROM ZELFSTANDIGNAAMWOORD " +
                    "WHERE zelfstandignaamwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,zelfstandignaamwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            
            String zelfstandignaamwoord_engels = result.getString("ENGELS");
            System.out.println(zelfstandignaamwoord_engels);

            return new Zelfstandignaamwoord(zelfstandignaamwoord_engels);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
public Zelfstandignaamwoord getZelfstandignaamwoordNL(String zelfstandignaamwoord) {
    	

        try {
            String queryText =  "SELECT ZELFSTANDIGNAAMWOORD " +
                    "FROM ZELFSTANDIGNAAMWOORD " +
                    "WHERE zelfstandignaamwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,zelfstandignaamwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            
            String zelfstandignaamwoord_nl = result.getString("ZELFSTANDIGNAAMWOORD");
            System.out.println(zelfstandignaamwoord_nl);

            return new Zelfstandignaamwoord(zelfstandignaamwoord_nl);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int createUniqueIDZelfstandignaamwoord() {
    	
        try {
            String queryText =  "SELECT MAX(ID) + 1 as newID " +
                    "FROM ZELFSTANDIGNAAMWOORD";

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


	public Zelfstandignaamwoord Save(Zelfstandignaamwoord zelfstandignaamwoord) {
		try (Connection con = getConnection()) {
			Statement stmt = con.createStatement();
			int uniek  = createUniqueIDZelfstandignaamwoord();
			
			String query = "INSERT INTO zelfstandignaamwoord (id, zelfstandignaamwoord)VALUES('" + uniek + "', '"+
					zelfstandignaamwoord.getZelfstandignaamwoord() + "')";
			
			stmt.executeUpdate(query);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return zelfstandignaamwoord;		
		
	}


	public boolean checkZelfstandignaamwoordDatabase(Zelfstandignaamwoord zelfstandignaamwoord) throws SQLException {
		
			boolean resultaat;
	        String queryText =  "SELECT zelfstandignaamwoord " +
	                "FROM zelfstandignaamwoord " +
	                "WHERE zelfstandignaamwoord  = ?";
	
	        PreparedStatement stmt = conn.prepareStatement(queryText);
	
	        stmt.setString(1,zelfstandignaamwoord.getZelfstandignaamwoord());
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
