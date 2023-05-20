/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import pmg.modelo.*;
import pmg.vista.*;

/**
 * @author jburg
 *
 */
public class ListenerBotonBaja implements ActionListener {

	private AccesoBBDD acceso;
	private VentanaAlumnos_Baja vab;
	private VentanaArea_Baja varb;
	private VentanaPI_Baja vpib;

	public ListenerBotonBaja(VentanaAlumnos_Baja vab, VentanaArea_Baja varb, VentanaPI_Baja vpib) {

		this.vab = vab;
		this.varb = varb;
		this.vpib = vpib;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		
		if (source == vab.getBtnBorrar()) {
			bajaAlumnos();
		}  else if (source == varb.getBtnBorrar()) {
			bajaArea();
		} else if (source == vpib.getBtnBorrar()) {
			bajaPI();
		}
	}
	
	public void bajaAlumnos() {
//		//Se recogen el código generado
//		String codigo = vab.getCodigo();
//		//Se crea un acceso a la bbdd y su conexión
//		acceso = new AccesoBBDD();
//		Connection con = acceso.getConexion();
//		//Comprobamos si el expediente es único
//		if (!acceso.existeExpedienteAlumno(con, datos.getNumExp())) {
//			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
//			vala.mostrarAviso(acceso.altaAlumno(con, datos)); //el método devuleve true o false			
//		} else {
//			vala.getAviso().setText("Número de expediente no válido");
//			vala.getLblCod().setText("");
//		}
//		acceso.cerrarConexion();
	}
	
	public void bajaArea() {
//		//Se recogen los datos introducidos por el usuario
//		DatosAltaArea datos = vara.getDatos();
//		//Se crea un acceso a la bbdd y su conexión
//		acceso = new AccesoBBDD();
//		Connection con = acceso.getConexion();
//		//Comprobamos si el nombre_corto es único
//		if (!acceso.existeNombreCortoArea(con, datos.getNombre_corto())) {
//			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
//			vara.mostrarAviso(acceso.altaArea(con, datos)); //el método devuleve true o false			
//		} else {
//			vara.getMensaje().setText("Nombre corto no válido");
//			vara.getAviso().setText("");
//		}
//		acceso.cerrarConexion();
	}
	
	public void bajaPI() {
//		//Se recogen los datos introducidos por el usuario
//		DatosAltaPI datos = vpia.getDatos();
//		//Se crea un acceso a la bbdd y su conexión
//		acceso = new AccesoBBDD();
//		Connection con = acceso.getConexion();
//		//Comprobamos si el nombre_corto es único
//		if (!acceso.existeNombrePI(con, datos.getNombre())) {
//			//Se modifica el label de la ventana Alumnos_Alta si en función de si se realiza la operación o no
//			vpia.mostrarAviso(acceso.altaPI(con, datos)); //el método devuleve true o false			
//		} else {
//			vpia.getLblAviso().setText("Nombre no válido");
//			vpia.getLblCod().setText("");
//		}
//		acceso.cerrarConexion();
	}

}
