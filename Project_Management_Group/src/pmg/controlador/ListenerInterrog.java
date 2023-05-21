package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.vista.*;

public class ListenerInterrog implements ActionListener {

	private VentanaAlumnos_Baja vab;
	private VentanaAlumnos_Consulta vac;
	private VentanaPI_Baja vpib;
	private VentanaPI_Consulta vpic;

	public ListenerInterrog(VentanaAlumnos_Baja vab, VentanaAlumnos_Consulta vac, VentanaPI_Baja vpib, VentanaPI_Consulta vpic) {
		this.vab = vab;
		this.vac = vac;
		this.vpib = vpib;
		this.vpic = vpic;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();

		if (source == vab.getBtnConsulta()) {
			vab.dispose();
			vac.hacerVisible();
		}  else if (source == vpib.getBtnConsulta()) {
			vpib.dispose();
			vpic.hacerVisible();

		}

	}
}
