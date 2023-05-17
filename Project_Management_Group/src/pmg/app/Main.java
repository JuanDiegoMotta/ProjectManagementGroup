package pmg.app;

import pmg.controlador.*;
import pmg.vista.*;

public class Main {

	public static void main(String[] args) {
		
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

		// Listener del botón que hace retroceder la pantalla en la que estamos situados.
		ListenerBotonAtras lba = new ListenerBotonAtras(vp, vala, vab, vae, vac, vara, varb, vare, vay, vpia, vpib, vpie, vpic);
		
		// Controladores de las ventanas
		vala.setControlador(lba);
		vab.setControlador(lba);
		vae.setControlador(lba);
		vac.setControlador(lba);
		vara.setControlador(lba);
		varb.setControlador(lba);
		vare.setControlador(lba);
		vay.setControlador(lba);
		vpia.setControlador(lba);
		vpib.setControlador(lba);
		vpie.setControlador(lba);
		vpic.setControlador(lba);
		vl.setControlador(lb);

	}
}
