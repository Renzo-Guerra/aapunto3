package DAOPersona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Persona;

public class MySQLDAOPersona implements DAOPersonaInterface{

	@Override
	public void createTable(Connection conn) {
		String table = "CREATE TABLE IF NOT EXISTS person("
				+ "id INT NOT NULL AUTO_INCREMENT,"
				+ "name VARCHAR(200),"
				+ "age INT,"
				+ "PRIMARY KEY(id))";
		try {
			conn.prepareStatement(table).execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPerson(Connection conn, Persona persona) {
		String query = "INSERT INTO person (name, age) values (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, persona.getNombre());
			ps.setInt(2, persona.getEdad());
			ps.executeUpdate();
			ps.close();
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
