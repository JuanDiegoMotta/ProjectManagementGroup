package pmg.app;

import pmg.controlador.*;
import pmg.vista.*;

/**
 * Clase principal que contiene el main para dar inicio a la aplicación
 * 
 * @author PMG
 */
public class Main {

	public static void main(String[] args) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				// Ventana Login
				VentanaLogIn vl = new VentanaLogIn();

				// Ventana principal con el menú
				VentanaPrincipal vp = new VentanaPrincipal();

				ListenerBoton lb = new ListenerBoton(vl, vp);

				vl.hacerVisible();

				// Ventana alta de alumnos
				VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta("Alta de alumnos");

				// Ventana baja de alumnos
				VentanaAlumnos_Baja vab = new VentanaAlumnos_Baja("Baja de alumnos");

				// Ventana edición de alumnos
				VentanaAlumnos_Edicion vae = new VentanaAlumnos_Edicion("Edición de alumnos");

				// Ventana consulta de alumnos
				VentanaAlumnos_Consulta vac = new VentanaAlumnos_Consulta("Consulta de alumnos");

				// Ventana alta de areas
				VentanaArea_Alta vara = new VentanaArea_Alta("Alta de áreas");

				// Ventana baja de áreas
				VentanaArea_Baja varb = new VentanaArea_Baja("Baja de áreas");

				// Ventana edición de áreas
				VentanaArea_Edicion vare = new VentanaArea_Edicion("Edición de áreas");

				// Ventana de ayuda
				VentanaAyuda vay = new VentanaAyuda("Ayuda");

				// Ventana alta proyectos
				VentanaPI_Alta vpia = new VentanaPI_Alta("Alta de proyectos");

				// Ventana baja de proyectos
				VentanaPI_Baja vpib = new VentanaPI_Baja("Baja de proyectos");

				// Ventana edición de proyectos
				VentanaPI_Edicion vpie = new VentanaPI_Edicion("Edición de proyectos");

				// Ventana consulta de proyectos
				VentanaPI_Consulta vpic = new VentanaPI_Consulta("Consulta de proyectos");

				VentanaPI_Asociar vpiaso = new VentanaPI_Asociar("Asociar alumnos");

				// Listener del botón que hace retroceder la pantalla en la que estamos
				// situados.
				ListenerBotonAtras lba = new ListenerBotonAtras(vp, vala, vab, vae, vac, vara, varb, vare, vay, vpia,
						vpib, vpie, vpic, vpiaso);
				// Creamos listener botón alta
				ListenerBotonAlta lbal = new ListenerBotonAlta(vala, vara, vpia);

				ListenerBotonBaja lbb = new ListenerBotonBaja(vab, varb, vpib);

				ListenerConsultas lc = new ListenerConsultas(vac, vpic, vpiaso, vpic);
				
				ListenerInterrog lin = new ListenerInterrog(vab, vac, vpib, vpic);
        
				ListenerMostrar lm = new ListenerMostrar(vae, vare, vpie);
				
				ListenerGuardar lg = new ListenerGuardar(vae, vare, vpie);
				// Controladores de las ventanas
				vala.setControlador(lba, lbal);
				vab.setControlador(lba, lbb, lin);
				vae.setControlador(lba, lm, lg);
				vac.setControlador(lba, lc);
				vara.setControlador(lba, lbal);
				varb.setControlador(lba, lbb);
				vare.setControlador(lba, lm, lg);
				vay.setControlador(lba);
				vpia.setControlador(lba, lbal);
				vpib.setControlador(lba, lbb, lin);
				vpie.setControlador(lba, lm, lg);
				vpic.setControlador(lba, lc);
				vl.setControlador(lb);

				// Controlador del Menu
				ListenerMenu listenerMenu = new ListenerMenu(vp, vpia, vpib, vpic, vpie, vala, vab, vac, vae, vara,
						varb, vare, vay, vpiaso);
				vp.setListenerMenu(listenerMenu);

				// Controlador para asociar alumnos a proyectos
				ListenerBotonAsociar ListenerBAsociar = new ListenerBotonAsociar(vpiaso);
				vpiaso.setControlador(lba, lc, ListenerBAsociar);
			}

		});
	}

}
