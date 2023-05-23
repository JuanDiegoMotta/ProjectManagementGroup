package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

public class ListenerInterrog implements ActionListener {

	private VentanaAlumnos_Baja vab;
	private VentanaAlumnos_Consulta vac;
	private VentanaPI_Baja vpib;
	private VentanaPI_Consulta vpic;
	private AccesoBBDD acceso;

	public ListenerInterrog(VentanaAlumnos_Baja vab, VentanaAlumnos_Consulta vac, VentanaPI_Baja vpib, VentanaPI_Consulta vpic) {
		this.vab = vab;
		this.vac = vac;
		this.vpib = vpib;
		this.vpic = vpic;
	}

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
