package DAOFactories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DAOPersona.DAOPersonaInterface;
import DAOPersona.MySQLDAOPersona;

public class MySQLDAOFactory implements DAOFactoryInterface{
	@Override
	public Connection connect() {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		String uri = "jdbc:mysql://localhost:3306/jdbcsql";
		
		try {
			DriverManager.getConnection(uri, "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}	
		
		return null;
	}

	@Override
	public DAOPersonaInterface getDaoPersona() {
		return new MySQLDAOPersona();
	}

}
