package DAOFactories;

import java.sql.Connection;

import DAOPersona.DAOPersonaInterface;

public interface DAOFactoryInterface {
	public Connection connect();
	public DAOPersonaInterface getDaoPersona();
}
