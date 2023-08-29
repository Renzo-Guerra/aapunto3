package utils;

public class DbConnection {
	private String driver;
	private String uri; 
	private static DbConnection conection;
	
	//singleton
	private DbConnection(String driver) {
		this.driver = driver;
	}
	
	// singleton
	public static DbConnection getInstance() {
		if( conection == null )
			conection = new DbConnection("jaja");
		return conection;
	}

}
