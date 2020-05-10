package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import nl.hu.v1wac.firstapp.model.Engels;

import nl.hu.v1wac.firstapp.model.Lidwoord;
import nl.hu.v1wac.firstapp.model.Werkwoord;
import nl.hu.v1wac.firstapp.model.Zelfstandignaamwoord;

public class EngelsDaoImpl extends OracleBaseDao implements EngelsDao {
	
	private Connection conn;
    private LidwoordDao ldao;
    private WerkwoordDao wdao;
    private ZelfstandignaamwoordDao zdao;
    

    public EngelsDaoImpl() {
        try {
            conn = super.getConnection();
            ldao = new LidwoordDaoImpl();
            wdao = new WerkwoordDaoImpl();
            zdao = new ZelfstandignaamwoordDaoImpl();
            
        } catch (SQLException e) {
            System.out.println("Error: could not connect to database.");
            e.printStackTrace();
        }
    }
		
	public Engels getEngels(String zin) throws SQLException {
		  Engels rep = null;
		try {

           String[] splited = zin.split("\\s+");

		    Lidwoord lidwoord = ldao.getLidwoord(splited[0]);
			Zelfstandignaamwoord zelfstandignaamwoord = zdao.getZelfstandignaamwoord(splited[1]);
			Werkwoord werkwoord = wdao.getWerkwoord(splited[2]);
			Lidwoord lidwoord1 = ldao.getLidwoord(splited[3]);
			Zelfstandignaamwoord zelfstandignaamwoord1 = zdao.getZelfstandignaamwoord(splited[4]);
			String engels = lidwoord.getLidwoord() +" "+ zelfstandignaamwoord.getZelfstandignaamwoord() +" "+ werkwoord.getWerkwoord() + " " + lidwoord1.getLidwoord() +" "+ zelfstandignaamwoord1.getZelfstandignaamwoord();
			 rep = new Engels(engels);
	        System.out.println(engels.toString());
	        return rep;}
		catch(NullPointerException|ArrayIndexOutOfBoundsException e) {
			 System.out.println("Error: zin niet correct/null/"+e);
		}
		
		return rep;

	}
	
	public String checkCharacters(String zin) {
		if(zin.contains("%20")) {
			zin = zin.replace("%20", " ");
			System.out.println(zin);
			return zin;
			
		}
		return zin;
			
			
		}




}
