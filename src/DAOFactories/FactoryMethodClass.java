package DAOFactories;

public class FactoryMethodClass {
	public final static String mysql = "mysql";
	public final static String derby = "derby";
	
	public static DAOFactoryInterface factoryMySQL;
	public static DAOFactoryInterface factoryDerby;
	
	public static DAOFactoryInterface getDao( String type ) {
		switch(type) {
			case mysql: {
				if(factoryMySQL == null)
					factoryMySQL = new MySQLDAOFactory();
				return factoryMySQL;
			}
			case derby: {
				if(factoryDerby == null)
					factoryDerby = new DerbyDAOFactory();
				return factoryDerby;
			}
			default: return null;
		}
	}
}
