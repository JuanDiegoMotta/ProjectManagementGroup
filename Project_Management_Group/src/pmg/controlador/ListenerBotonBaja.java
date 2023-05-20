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
		//Se recoge el código generado
		String codigo = vab.getCodigo();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		
		//Comprobamos si el código es único
		if (acceso.exiteCodigoAlumno(con, codigo)) {
			//Se modifica el label de la ventana Alumnos_Baja si en función de si se realiza la operación o no
			vab.mostrarAviso(acceso.bajaAlumno(con, codigo)); //el método devuleve true o false			
		} else {
			vab.getAviso().setText("Número de código no válido");
		}
		acceso.cerrarConexion();
	}
	
	/**
	 * Método que da de baja un área
	 */
	public void bajaArea() {

		//Se recoge el nombre corto del área introducido por el usuario
		String nc = varb.getNombreCorto();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		//Comprobamos si el nombre_corto existe
		if (acceso.existeNombreCortoArea(con, nc)) {
			//Se modifica el label de la ventana Area_Baja en función de si se realiza la operación o no
			varb.mostrarAviso(acceso.bajaArea(con, nc)); //el método devuleve true o false			
		} else {
			varb.getAviso().setText("El nombre corto introducido no existe");
		}
		acceso.cerrarConexion();

	}
	
	public void bajaPI() {

		//Se recoge el código del PI introducido por el usuario
		String cod = vpib.getCodigo();
		//Se crea un acceso a la bbdd y su conexión
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		//Comprobamos si el código existe
		if (acceso.existeCodigoPI(con, cod)) {
			//Se modifica el label de la ventana Baja PI en función de si se realiza la operación o no
			vpib.mostrarAviso(acceso.bajaPI(con, cod)); //el método devuleve true o false			
		} else {
			vpib.getAviso().setText("Código no válido");
		}
		acceso.cerrarConexion();

	}

}
