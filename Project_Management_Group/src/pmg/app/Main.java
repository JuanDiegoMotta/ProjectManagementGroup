package pmg.app;

import pmg.vista.*;

public class Main {

	public static void main(String[] args) {
		VentanaAlumnos_Alta VAlA = new VentanaAlumnos_Alta();
		VentanaAlumnos_Baja VAB = new VentanaAlumnos_Baja();
		VentanaAlumnos_Edicion VAE = new VentanaAlumnos_Edicion();
		VentanaAlumnos_Consulta VAC = new VentanaAlumnos_Consulta();

		VentanaArea_Alta VArA = new VentanaArea_Alta();
		VentanaArea_Baja VArB = new VentanaArea_Baja();
		VentanaArea_Edicion VArE = new VentanaArea_Edicion();

		VentanaAyuda VAy = new VentanaAyuda();
		VentanaLogIn VL = new VentanaLogIn();

		VentanaPI_Alta VPIA = new VentanaPI_Alta();
		VentanaPI_Baja VPIB = new VentanaPI_Baja();
		VentanaPI_Edicion BPIE = new VentanaPI_Edicion();
		VentanaPI_Consulta VPIC = new VentanaPI_Consulta();

	}

}
