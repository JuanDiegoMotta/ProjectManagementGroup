/**
 * 
 */
package pmg.controlador;

import java.awt.event.*;
import java.sql.*;

import pmg.modelo.*;
import pmg.vista.*;

/**
 * Clase que implementa la interfaz ActionListener para manejar eventos de botones de alta.
 * Proporciona el manejo de eventos cuando se hace clic en los botones de alta.
 * 
 * @author pmg
 *
 */
public class ListenerBotonAlta implements ActionListener {
	private AccesoBBDD acceso;
	private VentanaAlumnos_Alta vala;
	private VentanaArea_Alta vara;
	private VentanaPI_Alta vpia;

    /**
     * Constructor de la clase ListenerBotonAlta.
     *
     * @param vala la ventana de alumnos alta
     * @param vara la ventana alta de areas
     * @param vpia la ventana alta de proyectos integradores
     */
	public ListenerBotonAlta(VentanaAlumnos_Alta vala, VentanaArea_Alta vara, VentanaPI_Alta vpia) {
		this.vala = vala;
		this.vara = vara;
		this.vpia = vpia;
	}

	/**
	 * Invocado cuando ocurre un evento de acción sobre el botón
	 *
	 * @param e el objeto ActionEvent que contiene la información
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == vala.getBtnAlta()) {
			altaAlumnos();
		}  else if (source == vara.getBtnAlta()) {
			altaArea();
		} else if (source == vpia.getBtnAlta()) {
			altaPI();
		}
	}

	/**
	 * Método altaAlumnos() que se encarga de dar de alta a un alumno recogiendo los datos, creando la conexión a la BBDD 
	 * y llamando al método correspondiente de AccesoBBDD. También se encarga de cambiar el texto informativo sobre la
	 * modificación de la base de datos.
	 */
	public void altaAlumnos() {
		//Se recogen los datos introducidos por el usuario
		DatosAltaAlumno datos = vala.getDatos();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		//Comprobamos si el expediente es único
		if (!acceso.existeExpedienteAlumno(con, datos.getNumExp())) {
			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
			vala.mostrarAviso(acceso.altaAlumno(con, datos)); //el método devuleve true o false
			acceso.setDefaultPI(con, datos);
		} else {
			vala.getAviso().setText("Número de expediente no válido");
			vala.getLblCod().setText("");
		}
		acceso.cerrarConexion();
	}
	
	/**
	 * Método que se encarga de dar de alta a un área, creando la conexión con la base de datos y llamando al método de AccesoBBDD.
	 */
	public void altaArea() {
		//Se recogen los datos introducidos por el usuario
		Area datos = vara.getDatos();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		//Comprobamos si el nombre_corto es único
		if (!acceso.existeNombreCortoArea(con, datos.getNombre_corto())) {
			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
			vara.mostrarAviso(acceso.altaArea(con, datos)); //el método devuleve true o false			
		} else {
			vara.getMensaje().setText("Nombre corto no válido");
			vara.getAviso().setText("");
		}
		acceso.cerrarConexion();
	}
	
	/**
	 * Método que se encarga de dar de alta a un proyecto integrador, creando la conexión con la base de datos y llamando al método de AccesoBBDD.
	 */
	public void altaPI() {
		//Se recogen los datos introducidos por el usuario
		DatosAltaPI datos = vpia.getDatos();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		//Comprobamos si el nombre_corto es único
		if (!acceso.existeNombrePI(con, datos.getNombre())) {
			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
			vpia.mostrarAviso(acceso.altaPI(con, datos)); //el método devuleve true o false			
		} else {
			vpia.getLblAviso().setText("Nombre no válido");
			vpia.getLblCod().setText("");
		}
		acceso.cerrarConexion();
	}
}
