package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nl.hu.v1wac.firstapp.model.Lidwoord;
import nl.hu.v1wac.firstapp.model.Werkwoord;

public class WerkwoordDaoImpl extends OracleBaseDao implements WerkwoordDao {
	
	private Connection conn;

    public WerkwoordDaoImpl() {
        try {
            conn = super.getConnection();
        } catch (SQLException e) {
            System.out.println("Error: could not connect to database.");
            e.printStackTrace();
        }
    }
	
    public Werkwoord getWerkwoord(String werkwoord) {
    	

        try {
            String queryText =  "SELECT ENGELS " +
                    "FROM WERKWOORD " +
                    "WHERE werkwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,werkwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            String werkwoord_engels = result.getString("ENGELS");

            System.out.println(werkwoord_engels);

            return new Werkwoord(werkwoord_engels);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

public Werkwoord getWerkwoordNL(String werkwoord) {
    	

        try {
            String queryText =  "SELECT WERKWOORD " +
                    "FROM WERKWOORD " +
                    "WHERE werkwoord  = ?";

            PreparedStatement stmt = conn.prepareStatement(queryText);

            stmt.setString(1,werkwoord);
            ResultSet result = stmt.executeQuery();

            result.next();
            String werkwoord_nl = result.getString("WERKWOORD");

            System.out.println(werkwoord_nl);

            return new Werkwoord(werkwoord_nl);
        }
        catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

	    public int createUniqueIDWerkwoord() {
	
	        try {
	            String queryText =  "SELECT MAX(ID) + 1 as newID " +
	                    "FROM WERKWOORD";
	
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
	
	
		public Werkwoord Save(Werkwoord werkwoord) {
			try (Connection con = getConnection()) {
				Statement stmt = con.createStatement();
				int uniek  = createUniqueIDWerkwoord();
				
				String query = "INSERT INTO werkwoord (id, werkwoord)VALUES('" + uniek + "', '"+
						werkwoord.getWerkwoord() + "')";
				
				stmt.executeUpdate(query);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
			return werkwoord;		
			
		}


		public boolean checkWerkwoordDatabase(Werkwoord werkwoord) throws SQLException {
			
				boolean resultaat;
		        String queryText =  "SELECT werkwoord " +
		                "FROM werkwoord " +
		                "WHERE werkwoord  = ?";
		
		        PreparedStatement stmt = conn.prepareStatement(queryText);
		
		        stmt.setString(1,werkwoord.getWerkwoord());
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
