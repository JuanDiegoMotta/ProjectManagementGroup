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
	
	public void bajaArea() {

	}
	
	public void bajaPI() {

	}

}
