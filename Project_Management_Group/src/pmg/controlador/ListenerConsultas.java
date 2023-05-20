/**
 * 
 */
package pmg.controlador;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import pmg.modelo.*;
import pmg.vista.*;

/**
 * Controlador que maneja las consultas y muestra la información de Alumnos y Proyectos Integradores
 * en función del área seleccionada.
 * @author juanm
 *
 */
public class ListenerConsultas implements ItemListener {
	private VentanaAlumnos_Consulta vac;
	private VentanaPI_Consulta vpic;
	private AccesoBBDD acceso;
	
	/**
	 * Constructor de ListenerConsultas con parámetros
	 * @param vac Instancia de VentanaAlumnos_Consulta
	 * @param vpic Instancia de VentanaPI_Consulta
	 */
	public ListenerConsultas(VentanaAlumnos_Consulta vac, VentanaPI_Consulta vpic) {
		super();
		this.vac = vac;
		this.vpic = vpic;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if(source == vac.getAreasPi()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				rellenarTablaAlumnos((String) e.getItem());
			}
		}

	}
	
	public void rellenarTablaAlumnos(String area) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		vac.cargarTabla(acceso.getAlumnos(con, area));
		acceso.cerrarConexion();
	}

}
