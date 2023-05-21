package pmg.controlador;

import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import pmg.modelo.*;
import pmg.vista.*;

public class ListenerBotonAsociar implements ActionListener {

	private VentanaPI_Asociar vpiaso;
	private AccesoBBDD acceso;
	private ArrayList<String> lista = new ArrayList<>();

	public ListenerBotonAsociar(VentanaPI_Asociar vpiaso) {
		this.vpiaso = vpiaso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		int filaSeleccionada = vpiaso.getTblAlumnos().getSelectedRow();
		if (filaSeleccionada != -1) {
			String al = (String) vpiaso.getTableModel().getValueAt(filaSeleccionada, 0);
			if (acceso.existeNombrePI(con, vpiaso.getTxtnombre().getText())) {
				vpiaso.mostrarAviso(acceso.asociarAlumno(con, al, vpiaso.getTxtnombre().getText()));
			} else {
				vpiaso.getAviso().setText("Introduce un nombre de proyecto válido");
			}
		} else {
			vpiaso.getAviso().setText("Por favor, seleccione un alumno");
		}

		acceso.cerrarConexion();

	}

}
