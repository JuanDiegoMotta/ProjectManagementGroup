package pmg.controlador;

import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pmg.modelo.*;
import pmg.vista.*;

/**
 * Clase ListenerBotonAsociar
 * 
 * @author Pablo
 *
 */
public class ListenerBotonAsociar implements ActionListener {

	private VentanaPI_Asociar vpiaso;
	private AccesoBBDD acceso;
	private ArrayList<String> lista = new ArrayList<>();

	/**
	 * Constructor de la clase ListenerBotonAsociar
	 * 
	 * @param vpiaso Clase VentanaPI_Asociar
	 */
	public ListenerBotonAsociar(VentanaPI_Asociar vpiaso) {
		this.vpiaso = vpiaso;
	}

	/**
	 * Implementa el método actionPerformed de la interfaz ActionListener y define
	 * el comportamiento al hacer clic en el botón. Asocia al alumno con el proyeto
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		int filaSeleccionada = vpiaso.getTblAlumnos().getSelectedRow();// Recoge la fila seleccionada de la columna
		if (filaSeleccionada != -1) {
			String al = (String) vpiaso.getTableModel().getValueAt(filaSeleccionada, 0);// Guardamos en una String el
																						// valor de la fila seleccionada
			if (acceso.existeNombrePI(con, vpiaso.getTxtnombre().getText())) {// Si el nombre de proyecto existe
				// Le mostramos que el alumno ha sido asociado
				vpiaso.mostrarAviso(acceso.asociarAlumno(con, al, vpiaso.getTxtnombre().getText()));
			} else {
				vpiaso.getAviso().setText("Introduce un nombre de proyecto válido");// Si no nos muestra este texto
			}
		} else {
			vpiaso.getAviso().setText("Por favor, seleccione un alumno");
		}

		acceso.cerrarConexion();

	}

}
