package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.vista.VentanaAlumnos_Alta;
import pmg.vista.VentanaAlumnos_Baja;
import pmg.vista.VentanaAlumnos_Consulta;
import pmg.vista.VentanaAlumnos_Edicion;
import pmg.vista.VentanaArea_Alta;
import pmg.vista.VentanaArea_Baja;
import pmg.vista.VentanaArea_Edicion;
import pmg.vista.VentanaAyuda;
import pmg.vista.VentanaLogIn;
import pmg.vista.VentanaPI_Alta;
import pmg.vista.VentanaPI_Baja;
import pmg.vista.VentanaPI_Consulta;
import pmg.vista.VentanaPI_Edicion;
import pmg.vista.VentanaPrincipal;

public class ListenerBotonAtras implements ActionListener {

	private VentanaPrincipal vp;
	private VentanaAlumnos_Alta vala;
	private VentanaAlumnos_Baja vab;
	private VentanaAlumnos_Edicion vae;
	private VentanaAlumnos_Consulta vac;
	private VentanaArea_Alta vara;
	private VentanaArea_Baja varb;
	private VentanaArea_Edicion vare;
	private VentanaAyuda vay;
	private VentanaPI_Alta vpia;
	private VentanaPI_Baja vpib;
	private VentanaPI_Edicion vpie;
	private VentanaPI_Consulta vpic;
	
	
	/**
	 * Constructor de la clase Listener del botón que nos lleva atrás en las ventanas
	 * @param vp Ventana principal con el menú
	 * @param va Ventana alta de alumnos
	 */
	public ListenerBotonAtras(
			VentanaPrincipal vp, VentanaAlumnos_Alta vala, VentanaAlumnos_Baja vab, VentanaAlumnos_Edicion vae, 
			VentanaAlumnos_Consulta vac, VentanaArea_Alta vara, VentanaArea_Baja varb, VentanaArea_Edicion vare,
			VentanaAyuda vay, VentanaPI_Alta vpia, VentanaPI_Baja vpib, VentanaPI_Edicion vpie, VentanaPI_Consulta vpic) {
		this.vp = vp;
		this.vala = vala;
		this.vab = vab;
		this.vae = vae;
		this.vac = vac;
		this.vara = vara;
		this.varb = varb;
		this.vare = vare;
		this.vay = vay;
		this.vpia = vpia;
		this.vpib = vpib;
		this.vpie = vpie;
		this.vpic = vpic;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		vala.dispose();
		vab.dispose();
		vae.dispose();
		vac.dispose();
		vara.dispose();
		varb.dispose();
		vare.dispose();
		vay.dispose();
		vpia.dispose();
		vpib.dispose();
		vpie.dispose();
		vpic.dispose();
		vp.setVisible(true);
	}

}