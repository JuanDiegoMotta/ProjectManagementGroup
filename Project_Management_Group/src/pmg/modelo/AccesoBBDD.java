package pmg.modelo;

import java.beans.Statement;
import java.sql.*;

/**
 * Clase AccesoBBDD encargadad de crear la conexión con la base de datos
 * 
 * @author Pablo
 *
 */
public class AccesoBBDD {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/pmg";
	private String usuario = "root";
	private String pword = "ROOTROOT";
	private Connection con = null;

	static private int cont;

	/**
	 * Constructor de la clase AccesoBBDD
	 * 
	 * @param dat
	 */
	public AccesoBBDD() {
	}

	/**
	 * Método encargado de crear la conexión con la base de datos
	 * 
	 * @return
	 */
	public Connection getConexion() {

		try {
			// Primer paso transparencias, cargo el driver
			Class.forName(driver);
			// Segundo paso transparencias, establecemos conexion a la base de datos
			con = DriverManager.getConnection(url, usuario, pword);
			System.out.println("-- CONEXION ESTABLECIDA --");

		} catch (Exception e) {
			// Si algo falla imprime esto
			System.out.println("Error al establecer la conexion con BD");
			e.printStackTrace();
		}

		return con;
	}

	

	/**
	 * Método para cerrar la conexión con la base de datos
	 */
	public void cerrarConexion() {
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar BBDD");
			e.printStackTrace();
		}
	}

}
