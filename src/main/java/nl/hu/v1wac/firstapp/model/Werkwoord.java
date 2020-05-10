package nl.hu.v1wac.firstapp.model;

public class Werkwoord extends Grammatica {

	private String werkwoord;

	public Werkwoord(int id, String werkwoord) {
        super(id);
		this.werkwoord = werkwoord;
	}

	public Werkwoord(String werkwoord) {
		super();
		this.werkwoord = werkwoord;
	}

	public String getWerkwoord() {
		return werkwoord;
	}

	public void setWerkwoord(String werkwoord) {
		this.werkwoord = werkwoord;
	}

	
	
	
	
	
	
	
	
	

}
