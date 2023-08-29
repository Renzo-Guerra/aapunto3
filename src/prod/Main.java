package prod;

import java.sql.Connection;
import java.sql.SQLException;
import DAOFactories.*;
import DAOPersona.DAOPersonaInterface;
import entities.Persona;

public class Main {
	public static void main(String[] args) {
		// Solo cambiar la linea de abajo
		//DAOFactoryInterface factory1 = FactoryMethodClass.getDao(FactoryMethodClass.mysql);
		//DAOFactoryInterface factory2 = FactoryMethodClass.getDao(FactoryMethodClass.derby);
		DAOFactoryInterface factory = FactoryMethodClass.getDao(FactoryMethodClass.mysql);
				
		Connection conn = factory.connect();
		DAOPersonaInterface daoPersona = factory.getDaoPersona();
		
		try {
			daoPersona.createTable(conn);
			daoPersona.addPerson(conn, new Persona(1, "Juan", 23));
			daoPersona.addPerson(conn, new Persona(2, "Flor", 19));
			daoPersona.addPerson(conn, new Persona(3, "Micaela", 21));
			daoPersona.showTable(conn);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
