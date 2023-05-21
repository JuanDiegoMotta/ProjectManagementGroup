package pmg.modelo;

import java.sql.*;
import java.util.ArrayList;

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
	 * @return conection
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
	 * 
	 * @param con   instancia de una conexión a la base de datos
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
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método que da de alta el área a la base de datos
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param datos instancia de la clase que contiene los datos del area
	 * @return true si se realiza el insert, false en caso contrario
	 */
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
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método que da de alta un proyecto integrador a la base de datos
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param datos instancia de la clase que contiene los datos del area
	 * @return true si se realiza el insert, false en caso contrario
	 */
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
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método que da de baja el alumno de la base de datos
	 * 
	 * @param con instancia de una conexión a la base de datos
	 * @param cod código del alumno
	 * @return true si se realiza el insert, false en caso contrario
	 */
	public boolean bajaAlumno(Connection con, String cod) {

		// Guardamos el código en una varible
		String codigo = cod;

		// Creamos la query del prepared statement
		String query = "DELETE FROM ALUMNO WHERE cod_alumno = ?";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, codigo);

			resultado = pstmt.executeUpdate();
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método que ejecuta la sentencia para dar de baja un área
	 * 
	 * @param con instancia de tipo Connection
	 * @param nc  nombre corto del área a eliminar (String)
	 * @return booleano (true o false) en función de si se ejecuta la sentencia o no
	 */
	public boolean bajaArea(Connection con, String nc) {

		// Creamos la query del prepared statement
		String query = "DELETE FROM AREA WHERE nombre_corto = ?";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, nc);
			resultado = pstmt.executeUpdate();
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método que ejecuta la sentencia para dar de baja un PI
	 * 
	 * @param con instancia de tipo Connection
	 * @param cod código del PI a eliminar (String)
	 * @return booleano (true o false) en función de si se ejecuta la sentencia o no
	 */
	public boolean bajaPI(Connection con, String cod) {
		// Creamos la query del prepared statement
		String query = "DELETE FROM ProyectoIntegrador WHERE cod_proyecto = ?";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			// Rellenamos la query con los datos correspondientes
			pstmt.setString(1, cod);
			resultado = pstmt.executeUpdate();
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
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
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

	/**
	 * Método que comprueba si existe el código del alumno en la tabla alumno
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param valor cod_alumno (String) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean exiteCodigoAlumno(Connection con, String valor) {
		String query = "SELECT * FROM ALUMNO WHERE cod_alumno = ?";
		ResultSet rset;
		boolean flag = false;

		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			// cerramos cosas
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
	 * 
	 * @param con   instancia de una conexión a la base de datos
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
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Método que comprueba si existe el nombre del PI en la tabla
	 * ProyectoIntegrador
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param valor nombre (String) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean existeNombrePI(Connection con, String nombre) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE nombre = ?";
		ResultSet rset;
		boolean flag = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * Método que comprueba si existe el código del PI en la tabla
	 * ProyectoIntegrador
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param valor nombre (String) que comprobamos si existe
	 * @return true si existe, false si no
	 */
	public boolean existeCodigoPI(Connection con, String valor) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE cod_proyecto = ?";
		ResultSet rset;
		boolean flag = false;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, valor);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			flag = (rset.next()) ? true : false; // Si hay resultados se devuelve true, false en el caso contrario
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public ArrayList<Alumno> getAlumnos(Connection con, String area) {
		String query = "SELECT * FROM ALUMNO WHERE AREA = ?";
		ResultSet rset;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, area);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String exp = rset.getString(1);
				String nombre = rset.getString(2);
				String cod = rset.getString(3);
				String nc_area = rset.getString(4);
				alumnos.add(new Alumno(exp, nombre, cod, nc_area));
			}
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alumnos;
	}

	public ArrayList<ProyectoIntegrador> getProyetos(Connection con, String area) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE nc_area = ?";
		ResultSet rset;
		ArrayList<ProyectoIntegrador> proyectos = new ArrayList<ProyectoIntegrador>();
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, area);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				String año = rset.getString(1);
				String curso = rset.getString(2);
				String nota = rset.getString(3);
				String cod_proyecto = rset.getString(4);
				String nombre = rset.getString(5);
				String url = rset.getString(6);
				String nc_area = rset.getString(7);
				proyectos.add(new ProyectoIntegrador(año, curso, nota, cod_proyecto, nombre, url, nc_area));
			}
			// Cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proyectos;

	}

	public boolean asociarAlumno(Connection con, String nombreA, String nombreP) {
		boolean flag = false;
		System.out.println(nombreA);
		String query1 = "SELECT cod_alumno FROM Alumno WHERE nombre_ape = ?";
		ResultSet rset1 = null;
		String cod_alumno = null;
		try {
			PreparedStatement pstmt1 = con.prepareStatement(query1);
			pstmt1.setString(1, nombreA);
			rset1 = pstmt1.executeQuery();
			if (rset1.next()) {
				cod_alumno = rset1.getString("cod_alumno");
				System.out.println(cod_alumno);

			} else {
				flag = false;
			}
			// Cerraomos cosas
			rset1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(nombreP);
		String query2 = "SELECT cod_proyecto FROM ProyectoIntegrador WHERE nombre = ?";
		ResultSet rset2 = null;
		String cod_proyecto = null;
		try {
			PreparedStatement pstmt2 = con.prepareStatement(query2);
			pstmt2.setString(1, nombreP);
			rset2 = pstmt2.executeQuery();
			if (rset2.next()) {
				cod_proyecto = rset2.getString(1);
				System.out.println(cod_proyecto);
			} else {
				flag = false;
			}
			// Cerramos cosas
			pstmt2.close();
			rset2.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query3 = "INSERT INTO ProyectoIntegrador_Alumno (cod_alumno, cod_proyecto) VALUES (?, ?)";
		int resultado = 0;
		try {
			PreparedStatement pstmt3 = con.prepareStatement(query3);
			pstmt3.setString(1, cod_alumno);
			pstmt3.setString(2, cod_proyecto);
			resultado = pstmt3.executeUpdate();
			System.out.println(pstmt3);
			// Cerramos cosas
			pstmt3.close();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

}
