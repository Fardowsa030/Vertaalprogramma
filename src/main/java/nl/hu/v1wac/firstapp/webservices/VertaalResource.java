package nl.hu.v1wac.firstapp.webservices;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import nl.hu.v1wac.firstapp.model.Engels;
import nl.hu.v1wac.firstapp.model.Lidwoord;
import nl.hu.v1wac.firstapp.model.ServiceProvider;
import nl.hu.v1wac.firstapp.model.Structuur;
import nl.hu.v1wac.firstapp.model.VertaalService;
import nl.hu.v1wac.firstapp.model.Werkwoord;
import nl.hu.v1wac.firstapp.model.Zelfstandignaamwoord;

@Path("/representatie")
public class VertaalResource {
	
	private VertaalService Service = ServiceProvider.getVertaalService();
	
	
	 @GET
	 @Path("/engels/{zin}") 
	 @Produces("application/json")
	 public String getRepresentatie(@PathParam("zin") String zin) throws SQLException  {
		    String foutmelding = "foutmelding";
		    zin = Service.Check(zin);
		    System.out.println(zin);
		    Engels engels = Service.getEngels(zin);
			JsonObjectBuilder job = Json.createObjectBuilder();		
			job.add("engels", engels.getEngels());		
			job.add("foutmelding", foutmelding );
			return job.build().toString();		
			
		}
	 
	 
	
	 @GET
	 @Path("/structuur/{zin}") 
	 @Produces("application/json")
	 public String getStructuur(@PathParam("zin") String zin) throws SQLException  {
     	    zin = Service.Check(zin);
		    System.out.println(zin);
			Structuur structuur = Service.getStructuur(zin);
			
			JsonObjectBuilder job = Json.createObjectBuilder();
			job.add("lidwoord",structuur.getNl_lidwoord());
			job.add("zelfstandignaamwoord", structuur.getNl_zelfstandignaamwoord());
			job.add("werkwoord", structuur.getNl_werkwoord());
			job.add("lidwoord1", structuur.getNl_lidwoord1());
			job.add("zelfstandignaamwoord1", structuur.getNl_zelfstandignaamwoord1());
			
			return job.build().toString();		
			
		}
	
	 

	 
	 
	 @POST
     @Path("/lidwoordToevoegen")
     @Produces("application/json")
     public Response createLidwoord(@FormParam("lidwoord") String lidwoord) throws SQLException {
		     Response response = null;
		     System.out.println("lidwoord opslaan");
		     Lidwoord lidwoord_opslaan = new Lidwoord(Service.createUniqueIDLidwoord(),lidwoord);
		     boolean result = Service.checkLidwoordDatabase(lidwoord_opslaan);
		     if (result == true) {
		    	 System.out.println("lidwoord bestaat al");
		    	 response = Response.status(404).build();	    	 
		     }
		     else if(result == false) {
		    	 Service.save(lidwoord_opslaan);
	             System.out.println("lidwoord opgeslagen");;
	             response = Response.ok(lidwoord_opslaan).build();	    	 
		     }
		     return response;
   }
	 
	 @POST
     @Path("/werkwoordToevoegen")
     @Produces("application/json")
     public Response createWerkwoord(@FormParam("werkwoord") String werkwoord) throws SQLException {
		     Response response = null;
		     System.out.println(" opslaan werkwoord");
		     Werkwoord werkwoord_opslaan = new Werkwoord(Service.createUniqueIDWerkwoord(),werkwoord);
		     boolean result = Service.checkWerkwoordDatabase(werkwoord_opslaan);
		     if (result == true) {
		    	 System.out.println("werkwoord bestaat al");
		    	 response = Response.status(404).build();	    	 
		     }
		     else if(result == false) {
		    	 Service.save(werkwoord_opslaan);
	             System.out.println("werkwoord opgeslagen");;
	             response = Response.ok(werkwoord_opslaan).build();	    	 
		     }
		     return response;
   }
	 
	 @POST
     @Path("/zelfstandignaamwoordToevoegen")
     @Produces("application/json")
     public Response createZelfstandignaamwoord(@FormParam("zelfstandignaamwoord") String zelfstandignaamwoord) throws SQLException {
		     Response response = null;
		     System.out.println(" opslaan zelfstandignaamwoord");
		     Zelfstandignaamwoord zelfstandignaamwoord_opslaan = new Zelfstandignaamwoord(Service.createUniqueIDZelfstandignaamwoord(),zelfstandignaamwoord);
		     boolean result = Service.checkZelfstandignaamwoordDatabase(zelfstandignaamwoord_opslaan);
		     if (result == true) {
		    	 System.out.println("zelfstandignaamwoord bestaat al");
		    	 response = Response.status(404).build();	    	 
		     }
		     else if(result == false) {
		    	 Service.save(zelfstandignaamwoord_opslaan);
	             System.out.println("zelfstandignaamwoord opgeslagen");;
	             response = Response.ok(zelfstandignaamwoord_opslaan).build();	    	 
		     }
		     return response;
   }
	 
	 
	


}
