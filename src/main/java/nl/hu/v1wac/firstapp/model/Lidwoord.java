package nl.hu.v1wac.firstapp.model;

public class Lidwoord extends Grammatica {
    
	private String lidwoord;
	

	public Lidwoord(int id,String lidwoord) {
        super(id);
		this.lidwoord = lidwoord;
	}


	public Lidwoord(String lidwoord) {
		super();
		this.lidwoord = lidwoord;
	}


	public String getLidwoord() {
		return lidwoord;
	}


	public void setLidwoord(String lidwoord) {
		this.lidwoord = lidwoord;
	}


	
	
	

}
