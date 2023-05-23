package pmg.modelo;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 * Clase AccesoBBDD encargada de crear la conexión con la base de datos
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

	/**
	 * Constructor de la clase AccesoBBDD
	 * 
	 */
	public AccesoBBDD() {
	}

	/**
	 * Método encargado de crear la conexión con la base de datos
	 * 
	 * @return conection Devuelve la conexión a la base de datos
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
	 * Método que se encarga de crear un proyecto por defecto (Sin proyecto) por cada área nueva que se añada
	 * @param con Instancia de Connection
	 * @param datos Objeto de tipo DatosAltaAlumno
	 */
	public void setDefaultPI(Connection con, DatosAltaAlumno datos) {
		// Guardamos los datos en variables
		String nombre = datos.getNombreCompleto();
		String exp = datos.getNumExp();
		String area = datos.getArea();
		String cod = datos.getCodAlumno();
		// Creamos la query del prepared statement
		String query = "INSERT INTO ProyectoIntegrador_Alumno (cod_alumno, cod_proyecto) VALUES (?, ?)";
		PreparedStatement pstmt;
		int resultado = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cod);
			pstmt.setString(2, "S" + datos.getArea());
			resultado = pstmt.executeUpdate();
			// Imprimimos la query ejecutada
			System.out.println(pstmt);
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que da de alta el área a la base de datos
	 * 
	 * @param con   instancia de una conexión a la base de datos
	 * @param datos instancia de la clase que contiene los datos del area
	 * @return true si se realiza el insert, false en caso contrario
	 */
	public boolean altaArea(Connection con, Area datos) {
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
		// Añadimos el proyecto "sin proyecto" de esta area.
		DatosAltaPI datosPI = new DatosAltaPI("", "", "", "S" + nombre_corto, "Sin proyecto (" + nombre_corto + ")", "",
				nombre_corto);
		altaPI(con, datosPI);
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
			pstmt.setString(1, cod);// Rellenamos la query con los datos correspondientes
			resultado = pstmt.executeUpdate();
			System.out.println(pstmt);// Imprimimos la query ejecutada
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
	public boolean existeCodigoAlumno(Connection con, String valor) {
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

	/**
	 * Método encargado de guardar un un ArrayList de objeto Alumno con todos los
	 * atributos de dicho objeto pero solo en los que el alumno sea del área
	 * selecionada
	 * 
	 * @param con  Instancia de una conexión a la base de datos
	 * @param area nombre (String) de el área que haya selecionado el usuario
	 * @return El ArrayList que hemos rellenado con el select
	 */
	public ArrayList<Alumno> getAlumnos(Connection con, String area) {
		String query = "SELECT * FROM ALUMNO WHERE AREA = ?"; // Creamso la query
		ResultSet rset; // Inicializamos el ResultSet
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>(); // Creamos el ArrayList
		try {
			PreparedStatement pstmt = con.prepareStatement(query); // Creamos el PreparedStatement y le damos un valor
			pstmt.setString(1, area);
			rset = pstmt.executeQuery(); // Ejecutamos la query
			while (rset.next()) { // Mientras hay un siguiente resulado que vaya guardando el las variables los
									// resultados
				String exp = rset.getString(1);
				String nombre = rset.getString(2);
				String cod = rset.getString(3);
				String nc_area = rset.getString(4);
				alumnos.add(new Alumno(exp, nombre, cod, nc_area)); // Añadimos las variables al ArrayList
			}
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	/**
	 * Método encargado de guardar en un ArrayList de objeto ProyectoIntegrador con
	 * todos los atributos de dicho objeto pero solo en los que el alumno sea del
	 * área selecionada
	 * 
	 * @param con  Instancia de una conexión a la base de datos
	 * @param area nombre (String) de el área que haya selecionado el usuario
	 * @return El ArrayList que hemos rellenado con el select
	 */
	public ArrayList<ProyectoIntegrador> getProyetos(Connection con, String area) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE nc_area = ?"; // Creamos la query
		ResultSet rset; // Inicializamos el ResultSet
		ArrayList<ProyectoIntegrador> proyectos = new ArrayList<ProyectoIntegrador>(); // Creamos el ArrayList
		try {
			PreparedStatement pstmt = con.prepareStatement(query); // Creamos el PreparedStatement y le damos valor
			pstmt.setString(1, area);
			rset = pstmt.executeQuery(); // Ejecutamos la query
			while (rset.next()) { // Mientras hay un siguiente resulado que vaya guardando el las variables los
									// resultados
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
			e.printStackTrace();
		}
		return proyectos;
	}

	/**
	 * Método encargado de asociar al alumno que le pasamos como parámetro con el
	 * proyecto que le pasamos por parámetro. Como lo que pasamos como parámetro son
	 * los nombres, tenemos que hacer un select tanto al nombre del alumno, como al
	 * nombre del proyecto para poder conseguir los códigos con lo que ya si que
	 * podremos hacer el insert en la tabla que los une
	 * 
	 * @param con     Instancia de una conexión a la base de datos
	 * @param nombreA Nombre (String) de el nombre de el alumno
	 * @param nombreP Nombre (String) de el nombre de el proyectoIntegrador
	 * @return
	 */
	public boolean asociarAlumno(Connection con, String nombreA, String nombreP) {
		boolean flag = false; // Creamos la flag
		String query1 = "SELECT cod_alumno FROM Alumno WHERE nombre_ape = ?";// Creamos la query1
		ResultSet rset1 = null; // Creamos el ResultSet1
		String cod_alumno = null;// Creamos el cod_alumno
		try {
			PreparedStatement pstmt1 = con.prepareStatement(query1);// Creamos el PreparedStatement y le damos valor
			pstmt1.setString(1, nombreA);
			rset1 = pstmt1.executeQuery();// Ejecutamos la query
			if (rset1.next()) {
				cod_alumno = rset1.getString("cod_alumno");// Guardamos el cod_alumno el valor que nos devuelve la
															// query1
			} else {
				flag = false;
			}
			// Cerraomos cosas
			rset1.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query2 = "SELECT cod_proyecto FROM ProyectoIntegrador WHERE nombre = ?";// Creamos la query2
		ResultSet rset2 = null;// Creamos el ResultSet2
		String cod_proyecto = null;// Creamos cod_proyecto
		try {
			PreparedStatement pstmt2 = con.prepareStatement(query2);// Creamos el PreparedStatement y le damos valor
			pstmt2.setString(1, nombreP);
			rset2 = pstmt2.executeQuery();// Ejecutamos la query2
			if (rset2.next()) {
				cod_proyecto = rset2.getString(1);// Guardamos en cod_proyeto el resultado de la query
			} else {
				flag = false;
			}
			// Cerramos cosas
			pstmt2.close();
			rset2.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query3 = "UPDATE ProyectoIntegrador_Alumno SET cod_proyecto = ? WHERE cod_alumno = ?";// Creamos la
																										// query3
		int resultado = 0;// Creamos resultado
		try {
			PreparedStatement pstmt3 = con.prepareStatement(query3);// Creamos el PreparedStatement y le damos valor
			pstmt3.setString(1, cod_proyecto);
			pstmt3.setString(2, cod_alumno);
			resultado = pstmt3.executeUpdate();// Ejecutamos la query3
			System.out.println(pstmt3);
			// Cerramos cosas
			pstmt3.close();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * Método encargado de hacer el update en la tabla Area con los nuevos datos que
	 * haya creado el usuario
	 * 
	 * @param con          Instancia de una conexión a la base de datos
	 * @param nombre_corto Nombre corto (String) de la área
	 * @param descripcion  Descripción (String) de la área
	 * @return Devuelve
	 */
	public boolean edicionArea(Connection con, String nombre_corto, String descripcion) {

		String query = "UPDATE AREA SET descripcion = ? WHERE nombre_corto = ?";// Creammos la query
		int resultado = 0;// Creamos resultado
		try {
			PreparedStatement pstmt = con.prepareStatement(query);// Creamos el Preparedstatement
			pstmt.setString(1, descripcion);
			pstmt.setString(2, nombre_corto);
			resultado = pstmt.executeUpdate();// Ejecutamos la query
			System.out.println(pstmt);
			// Cerramos cosas
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Hacemos que devuelva true si se modifica la tabla, false en el caso contrario
		return (resultado == 1) ? true : false;
	}

	/**
	 * Método getInfoAlumno que devuelve la información de un alumno según su código
	 * 
	 * @param con        Objeto de tipo Connection
	 * @param cod_alumno Código del alumno
	 * @return información del alumno a través de un objeto de DatosAltaAlumno
	 */
	public DatosAltaAlumno getInfoAlumno(Connection con, String cod_alumno) {
		String query = "SELECT * FROM ALUMNO WHERE cod_alumno = ?";
		ResultSet rset;
		String num_exp = "";
		String nombre_ape = "";
		String area = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cod_alumno);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				num_exp = rset.getString(1);
				nombre_ape = rset.getString(2);
				area = rset.getString(4);
				System.out.println(pstmt);
				// cerramos cosas
				rset.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatosAltaAlumno datosBaja = new DatosAltaAlumno(nombre_ape, num_exp, cod_alumno, area);
		return datosBaja;
	}

	/**
	 * Método que se encarga de ejcutar la query para recoger los datos de un área
	 * según su nombre corto
	 * 
	 * @param con     Instancia de tipo Connection
	 * @param nc_area nombre corto del área
	 * @return objeto de DatosAltaArea
	 */
	public Area getInfoArea(Connection con, String nc_area) {
		String query = "SELECT * FROM AREA WHERE nombre_corto = ?";
		ResultSet rset;
		String descripcion = "";
		String cod_area = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nc_area);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				descripcion = rset.getString(3);
				cod_area = rset.getString(2);
				System.out.println(pstmt);
				// cerramos cosas
				rset.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Area datosBaja = new Area(nc_area, cod_area, descripcion);
		return datosBaja;
	}

	/**
	 * Método que se encarga de conseguir la información de un PI según su código de
	 * proyecto
	 * 
	 * @param con Objeto de tipo Connection
	 * @param cod Código del proyecto
	 * @return objeto de DatosAltaPI
	 */
	public DatosAltaPI getInfoPI(Connection con, String cod) {
		String query = "SELECT * FROM ProyectoIntegrador WHERE cod_proyecto = ?";
		ResultSet rset;
		String ano = "";
		String curso = "";
		String nota = "";
		String nombre = "";
		String url = "";
		String nc_area = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, cod);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				ano = rset.getString(1);
				curso = rset.getString(2);
				nota = rset.getString(3);
				nombre = rset.getString(5);
				url = rset.getString(6);
				nc_area = rset.getString(7);
				System.out.println(pstmt);
				// cerramos cosas
				rset.close();
				pstmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatosAltaPI datosBaja = new DatosAltaPI(ano, curso, nota, cod, nombre, url, nc_area);
		return datosBaja;
	}

	/**
	 * Método que devuelve un arraylist con los registros de la tabla
	 * ProyectoIntegrador_Alumno de un área determinada
	 * 
	 * @param con  Instancia de tipo Connection
	 * @param area area del proyecto y alumno
	 * @return ArrayList de DatosAsociaciones
	 */
	public ArrayList<DatosAsociaciones> getAsociaciones(Connection con, String area) {
		ArrayList<DatosAsociaciones> datos = new ArrayList<>();
		String query = "SELECT a.nombre_ape, p.nombre \r\n"
				+ "FROM Alumno a, ProyectoIntegrador p, ProyectoIntegrador_Alumno pa\r\n"
				+ "WHERE a.cod_alumno = pa.cod_alumno AND p.cod_proyecto = pa.cod_proyecto AND a.area = ? ORDER BY p.nombre ASC;";
		ResultSet rset;
		String nombreAl;
		String nombrePI;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, area);
			rset = pstmt.executeQuery();
			System.out.println(pstmt);
			while (rset.next()) {
				nombreAl = rset.getString(1);
				nombrePI = rset.getString(2);
				datos.add(new DatosAsociaciones(nombreAl, nombrePI));
			}
			// cerramos cosas
			rset.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datos;
	}

	/**
	 * Método que comprueba que el área del PI y el área del Alumno seleccionados en
	 * la ventana PI_Asociar son iguales
	 * 
	 * @param nombrePI nombre del PI (String)
	 * @param nombreAl nombre alumno (String)
	 * @return booleano true (si son iguales) o false (si no lo son)
	 */
	public boolean concuerdanAreas(String nombrePI, String nombreAl) {
		String query = "SELECT p.nc_area, a.area FROM ProyectoIntegrador p, Alumno a WHERE p.nombre = '" + nombrePI
				+ "' AND a.nombre_ape = '" + nombreAl + "'";
		ResultSet rset;
		String areaPI = "a";
		String areaAl = "b";
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				areaPI = rset.getString(1);
				areaAl = rset.getString(2);
			}
			System.out.println(stmt);
			// cerramos cosas
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (areaPI.equals(areaAl)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Método que devuelve un JComboBox de las áreas en la base de datos
	 * 
	 * @param con Instancia de Connection
	 * @return JComboBox<String> de áreas
	 */
	public ArrayList<String> conseguirAreas(Connection con) {

		String query = "SELECT nombre_corto FROM AREA";
		System.out.println(query);
		ResultSet rset;
		ArrayList<String> areas = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				areas.add(rset.getString(1));
			}
			// cerramos cosas
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areas;
	}

	/**
	 * Método que se encarga de hacer un update de la descripción del área pasada
	 * por parámetro
	 * 
	 * @param con         Instancia de Connection
	 * @param descripcion Descripción del area modificada (String)
	 * @param area        area que se modifica (String)
	 * @return
	 */
	public boolean updateArea(Connection con, String descripcion, String area) {
		String query = "UPDATE AREA SET descripcion = ? WHERE nombre_corto = ?";
		int registros = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, descripcion);
			pstmt.setString(2, area);
			System.out.println(pstmt);
			registros = pstmt.executeUpdate();
			// cerramos cosas
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (registros != 0) ? true : false;
	}

	/**
	 * Método que hace un update con datos modificados de una alumno que se pasan
	 * por parámetros
	 * 
	 * @param con        Instancia de Connection
	 * @param cod_alumno código del alumno a modificar
	 * @param nombre_ape nombre y apellido del alumno
	 * @return
	 */
	public boolean updateAlumno(Connection con, String cod_alumno, String nombre_ape) {
		String query = "UPDATE ALUMNO SET nombre_ape = ? WHERE cod_alumno = ?";
		int registros = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre_ape);
			pstmt.setString(2, cod_alumno);
			System.out.println(pstmt);
			registros = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (registros != 0) ? true : false;
	}

	/**
	 * Método que hace un update en la base de datos de un PI que se está editando.
	 * 
	 * @param con          Instancia de tipo connection
	 * @param cod_proyecto código del proyecto que se quiere modificar (String)
	 * @param nombre       nombre del proyecto (String)
	 * @param curso        curso (String)
	 * @param nota         nota (String)
	 * @param ano          año (String)
	 * @param url          url de github (String)
	 * @return true si se realiza el update, sino false
	 * @throws SQLIntegrityConstraintViolationException Excepción lanzada si se
	 *                                                  intenta modificar el nombre
	 *                                                  a uno ya exitente
	 */
	public boolean updatePI(Connection con, String cod_proyecto, String nombre, String curso, String nota, String ano,
			String url) throws SQLIntegrityConstraintViolationException {
		String query = "UPDATE ProyectoIntegrador SET nombre = ?, curso = ?, nota = ?, ano = ? WHERE cod_proyecto = ?";
		int registros = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			pstmt.setString(2, curso);
			pstmt.setString(3, nota);
			pstmt.setString(4, ano);
			pstmt.setString(5, cod_proyecto);
			System.out.println(pstmt);
			registros = pstmt.executeUpdate();
			// cerramos cosas
			pstmt.close();
		} catch (SQLIntegrityConstraintViolationException e1) {
			throw new SQLIntegrityConstraintViolationException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (registros != 0) ? true : false;
	}

}
