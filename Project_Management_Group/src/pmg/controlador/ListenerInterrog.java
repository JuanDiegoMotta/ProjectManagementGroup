package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase del controlador del botón interrogación que implementa la interfaz ActionListener y define el comportamiento para los eventos de acción.
 * 
 * @author PMG
 */
public class ListenerInterrog implements ActionListener {

	private VentanaAlumnos_Baja vab;
	private VentanaAlumnos_Consulta vac;
	private VentanaPI_Baja vpib;
	private VentanaPI_Consulta vpic;
	private AccesoBBDD acceso;

    /**
     * Constructor de la clase ListenerInterrog.
     *
     * @param vab  VentanaAlumnos_Baja utilizada en el listener.
     * @param vac  VentanaAlumnos_Consulta utilizada en el listener.
     * @param vpib VentanaPI_Baja utilizada en el listener.
     * @param vpic VentanaPI_Consulta utilizada en el listener.
     */
	public ListenerInterrog(VentanaAlumnos_Baja vab, VentanaAlumnos_Consulta vac, VentanaPI_Baja vpib, VentanaPI_Consulta vpic) {
		this.vab = vab;
		this.vac = vac;
		this.vpib = vpib;
		this.vpic = vpic;
	}

	/**
	 * Implementa el método actionPerformed de la interfaz ActionListener y define el comportamiento al hacer clic en el botón.
	 * Llama a los métodos de las consultas y bajas de las diferentes ventanas de consultas y bajas.
	 * 
	 * @param e el evento que disparó la acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if (source == vab.getBtnConsulta()) {
			vab.dispose();
			vac.hacerVisible();
	        vac.setAreasList(acceso.conseguirAreas(con));
	        vac.rellenarComboBox();
		}  else if (source == vpib.getBtnConsulta()) {
			vpib.dispose();
			vpic.hacerVisible();
			vpic.setAreasList(acceso.conseguirAreas(con));
			vpic.rellenarComboBox();

		}

	}
}
