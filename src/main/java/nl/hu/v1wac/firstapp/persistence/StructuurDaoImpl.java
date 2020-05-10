package nl.hu.v1wac.firstapp.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import nl.hu.v1wac.firstapp.model.Engels;

import nl.hu.v1wac.firstapp.model.Lidwoord;
import nl.hu.v1wac.firstapp.model.Structuur;
import nl.hu.v1wac.firstapp.model.Werkwoord;
import nl.hu.v1wac.firstapp.model.Zelfstandignaamwoord;

public class StructuurDaoImpl extends OracleBaseDao implements StructuurDao {
	
	private Connection conn;
    private LidwoordDao ldao;
    private WerkwoordDao wdao;
    private ZelfstandignaamwoordDao zdao;
    

    public StructuurDaoImpl() {
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
		public Structuur getStructuur(String zin) {
			
		    
			   String[] splited = zin.split("\\s+");
			           
			
			        
			  Lidwoord lidwoord = ldao.getLidwoordNL(splited[0]);
			  Zelfstandignaamwoord zelfstandignaamwoord = zdao.getZelfstandignaamwoordNL(splited[1]);
			  Werkwoord werkwoord = wdao.getWerkwoordNL(splited[2]);
			  Lidwoord lidwoord1 = ldao.getLidwoordNL(splited[3]);
			  Zelfstandignaamwoord zelfstandignaamwoord1 = zdao.getZelfstandignaamwoordNL(splited[4]);
			  Structuur structuur = new Structuur(lidwoord.getLidwoord(),zelfstandignaamwoord.getZelfstandignaamwoord(),werkwoord.getWerkwoord(),lidwoord1.getLidwoord(),
					  zelfstandignaamwoord1.getZelfstandignaamwoord());
			  System.out.println(structuur.toString());
			
			  return structuur;
						
			
				}

}
