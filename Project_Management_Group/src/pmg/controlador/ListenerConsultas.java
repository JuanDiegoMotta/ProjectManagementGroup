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
 * Controlador que maneja las consultas y muestra la información de Alumnos y
 * Proyectos Integradores en función del área seleccionada.
 * 
 * @author juanm
 *
 */
public class ListenerConsultas implements ItemListener {
	private VentanaAlumnos_Consulta vac;
	private VentanaPI_Consulta vpic;
	private AccesoBBDD acceso;
	private VentanaPI_Asociar vpiaso;
	private VentanaPI_Consulta vpicon;

	/**
	 * Constructor de ListenerConsultas con parámetros
	 * 
	 * @param vac  Instancia de VentanaAlumnos_Consulta
	 * @param vpic Instancia de VentanaPI_Consulta
	 */
	public ListenerConsultas(VentanaAlumnos_Consulta vac, VentanaPI_Consulta vpic, VentanaPI_Asociar vpiaso,
			VentanaPI_Consulta vpicon) {
		super();
		this.vac = vac;
		this.vpic = vpic;
		this.vpiaso = vpiaso;
		this.vpicon = vpicon;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource();
		if (source == vac.getAreasPi()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				rellenarTablaAlumnos(((String) e.getItem()), vac);
			}
		} else if (source == vpiaso.getAreasPi()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				rellenarTablaAsociar((String) e.getItem());
			}
		} else if (source == vpicon.getAreasPi()) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				rellenarTablaProyectos((String) e.getItem());
			}
		}

	}

	public void rellenarTablaAlumnos(String area, Object o) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if (o instanceof VentanaAlumnos_Consulta) {
			vac.cargarTabla(acceso.getAlumnos(con, area));

		} 
		acceso.cerrarConexion();
	}

	public void rellenarTablaProyectos(String area) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		vpicon.cargarTabla(acceso.getProyetos(con, area));
		acceso.cerrarConexion();

	}
	
	public void rellenarTablaAsociar(String area) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		vpiaso.cargarTabla(acceso.getAsociaciones(con, area));
		acceso.cerrarConexion();
	}

}
