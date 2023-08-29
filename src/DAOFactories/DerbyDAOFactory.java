package DAOFactories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAOPersona.DAOPersonaInterface;
import DAOPersona.DerbyDAOPersona;

public class DerbyDAOFactory implements DAOFactoryInterface{

	@Override
	public Connection connect() {
		String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri = "jdbc:derby:derbyDb;create=true";
		
		try {
			return DriverManager.getConnection(uri);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		return null;
	}

	@Override
	public DAOPersonaInterface getDaoPersona() {
		return new DerbyDAOPersona();
	}

}
