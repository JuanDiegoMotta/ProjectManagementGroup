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
	private String pword = "root";
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
			System.out.println("-- CONEXION CERRADA --");
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al cerrar BBDD");
			e.printStackTrace();
		}
	}

	/**
	 * Método que da de alta un alumno en la base de datos
	 * @param con instancia de una conexión a la base de datos
	 * @param datos instancia de la clase que contiene los datos del alta del alumno
	 * @return true si se realiza el insert, false en caso contrario
	 */
	public boolean altaAlumno(Connection con, DatosAltaAlumno datos) {
		// Guardamos los datos en variables
		String nombre = datos.getNombreCompleto();
		String exp = datos.getNumExp();
		String area = datos.getArea();
		String cod = datos.getCodAlumno(); 
		// Creamos la query del prepared statement
		String query = "INSERT INTO ALUMNO (num_expediente, nombre_ape, cod_alumno, area) VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, exp);
			pstmt.setString(2, nombre);
			pstmt.setString(3, cod);
			pstmt.setString(4, area);
			resultado = pstmt.executeUpdate();
			//Imprimimos la query ejecutada
			System.out.println(pstmt);
			//cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}
	public boolean altaArea(Connection con, DatosAltaArea datos) {
		// Guardamos los datos en variables
		String nombre_corto = datos.getNombre_corto();
		String cod_area = datos.getCod_area();
		String descripcion = datos.getDescripcion();
		
		// Creamos la query del prepared statement
		String query = "INSERT INTO AREA (nombre_corto, cod_area, descripcion) VALUES (?, ?, ?)";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, nombre_corto);
			pstmt.setString(2, cod_area);
			pstmt.setString(3, descripcion);
			resultado = pstmt.executeUpdate();
			//Imprimimos la query ejecutada
			System.out.println(pstmt);
			//cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}
	public boolean altaPI(Connection con, DatosAltaPI datos) {
		// Guardamos los datos en variables
		String año = datos.getAño();
		String curso = datos.getCurso();
		String nota = datos.getNota();
		String cod_proyecto = datos.getCod_proyecto();
		String nombre = datos.getNombre();
		String url = datos.getUrl();
		String nc_area = datos.getNc_area();
		
		// Creamos la query del prepared statement
		String query = "INSERT INTO ProyectoIntegrador (ano, curso, nota, cod_proyecto, nombre, url, nc_area) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, año);
			pstmt.setString(2, curso);
			pstmt.setString(3, nota);
			pstmt.setString(4, cod_proyecto);
			pstmt.setString(5, nombre);
			pstmt.setString(6, url);
			pstmt.setString(7, nc_area);
			resultado = pstmt.executeUpdate();
			//Imprimimos la query ejecutada
			System.out.println(pstmt);
			//cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}
	
	/**
	 * Método que comprueba si existe el expediente del alumno en la tabla alumnos
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param valor expediente (string) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean existeExpedienteAlumno(Connection con, String valor) {
		String query = "SELECT * FROM ALUMNO WHERE num_expediente = ?";
		ResultSet rset;
		boolean flag = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			//cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}
	
	/**
	 * Método que comprueba si existe el nombre corto del area en la tabla area
	 * @param con instancia de una conexión a la base de datos
	 * @param valor nombre corto (String) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean existeNombreCortoArea(Connection con, String valor) {
		String query = "SELECT * FROM AREA WHERE nombre_corto = ?";
		ResultSet rset;
		boolean flag = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			//cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * Método que comprueba si existe el nombre del PI en la tabla ProyectoIntegrador
	 * @param con instancia de una conexión a la base de datos
	 * @param valor nombre (String) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean existeNombrePI(Connection con, String valor) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE nombre = ?";
		ResultSet rset;
		boolean flag = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			//cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
