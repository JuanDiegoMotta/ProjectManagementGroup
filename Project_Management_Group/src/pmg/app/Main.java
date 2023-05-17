package pmg.app;

import pmg.controlador.*;
import pmg.vista.*;

public class Main {

	public static void main(String[] args) {
		
		
		VentanaLogIn vl = new VentanaLogIn();
		VentanaPrincipal vp = new VentanaPrincipal();
		ListenerBoton lb = new ListenerBoton(vl, vp);
		
		vl.hacerVisible();
//		Hace que dentro de la ventana funcione el controlador
		vl.setControlador(lb);
//		VentanaAlumnos_Alta vala = new VentanaAlumnos_Alta();
//		VentanaAlumnos_Baja vab = new VentanaAlumnos_Baja();
//		VentanaAlumnos_Edicion vae = new VentanaAlumnos_Edicion();
//		VentanaAlumnos_Consulta vac = new VentanaAlumnos_Consulta();
//
//		VentanaArea_Alta vara = new VentanaArea_Alta();
//		VentanaArea_Baja varb = new VentanaArea_Baja();
//		VentanaArea_Edicion vare = new VentanaArea_Edicion();
//
//		VentanaAyuda vay = new VentanaAyuda();
//		
//
//		VentanaPI_Alta vpia = new VentanaPI_Alta();
//		VentanaPI_Baja vpib = new VentanaPI_Baja();
//		VentanaPI_Edicion bpie = new VentanaPI_Edicion();
//		VentanaPI_Consulta vpic = new VentanaPI_Consulta();
		
		

	}

}
