package DAOPersona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Persona;

public class DerbyDAOPersona implements DAOPersonaInterface{
	
	
	//public void createTable() {
	@Override
	public void createTable(Connection conn) {
		String table = "CREATE TABLE person("
				+ "id INT,"
				+ "name VARCHAR(200),"
				+ "age INT,"
				+ "PRIMARY KEY(id))";
		try {
			// DbConnetion.getInstance().prepareStatement(table).execute();
			conn.prepareStatement(table).execute();
			conn.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPerson(Connection conn, Persona persona) {
		String query = "INSERT INTO person (id, name, age) values (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, persona.getId());
			ps.setString(2, persona.getNombre());
			ps.setInt(3, persona.getEdad());
			ps.executeUpdate();
			ps.close();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showTable(Connection conn) {
		String query = "SELECT * FROM person";
		try {			
			PreparedStatement ps = conn.prepareStatement(query);
			// Al ejecutar la consulta, devuelve un "cursor"
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
