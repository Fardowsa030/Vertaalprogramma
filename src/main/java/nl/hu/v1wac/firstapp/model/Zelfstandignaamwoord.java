package nl.hu.v1wac.firstapp.model;

public class Zelfstandignaamwoord extends Grammatica {

	private String zelfstandignaamwoord;
	
	
	
	
	public Zelfstandignaamwoord(int id, String zelfstandignaamwoord) {
		super(id);
		this.zelfstandignaamwoord = zelfstandignaamwoord;
	}



	public Zelfstandignaamwoord(String zelfstandignaamwoord) {
		super();
		this.zelfstandignaamwoord = zelfstandignaamwoord;
	}



	public String getZelfstandignaamwoord() {
		return zelfstandignaamwoord;
	}


	public void setZelfstandignaamwoord(String zelfstandignaamwoord) {
		this.zelfstandignaamwoord = zelfstandignaamwoord;
	}




	
	
	
	
	
	

}
