package nl.hu.v1wac.firstapp.model;

public class ServiceProvider {
	
	private static VertaalService vertaalService = new VertaalService();

    public static VertaalService getVertaalService() {

        return vertaalService;

    }

}
