package DAOPersona;

import java.sql.Connection;

import entities.Persona;

public interface DAOPersonaInterface {
	public void createTable(Connection conn);
	public void addPerson(Connection conn, Persona persona);
	public void showTable(Connection conn);
}
