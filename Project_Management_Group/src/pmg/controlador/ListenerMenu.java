package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase que implementa la interfaz ActionListener para manejar eventos de los botones del menú. 
 * Proporciona el manejo de eventos cuando se hace clic en los botones del menú.
 * 
 * @author PMG
 */
public class ListenerMenu implements ActionListener {
	
	private VentanaPrincipal VPpal;
	private VentanaPI_Alta VPI_alta;
	private VentanaPI_Baja VPI_baja;
	private VentanaPI_Consulta VPI_consulta;
	private VentanaPI_Edicion VPI_edicion;
	private VentanaAlumnos_Alta VAl_alta;
	private VentanaAlumnos_Baja VAl_baja;
	private VentanaAlumnos_Consulta VAl_consulta;
	private VentanaAlumnos_Edicion VAl_edicion;
	private VentanaArea_Alta VAr_alta;
	private VentanaArea_Baja VAr_baja;
	private VentanaArea_Edicion VAr_edicion;
	private VentanaAyuda Vay;
	private VentanaPI_Asociar vpiaso;
	private AccesoBBDD acceso;
	
	/**
	 * Constructor de ListenerMenu con las ventanas correspondientes para cada opción del menú.
	 *
	 * @param vPpal la ventana principal
	 * @param vPI_alta la ventana de alta de proyectos
	 * @param vPI_baja la ventana de baja de proyectos
	 * @param vPI_consulta la ventana de consulta de proyectos
	 * @param vPI_edicion la ventana de edición de proyectos
	 * @param vAl_alta la ventana de alta de alumnos
	 * @param vAl_baja la ventana de baja de alumnos
	 * @param vAl_consulta la ventana de consulta de alumnos
	 * @param vAl_edicion la ventana de edición de alumnos
	 * @param vAr_alta la ventana de alta de áreas
	 * @param vAr_baja la ventana de baja de áreas
	 * @param vAr_edicion la ventana de edición de áreas
	 * @param vAy la ventana de ayuda
	 */
	public ListenerMenu(VentanaPrincipal vPpal, VentanaPI_Alta vPI_alta, VentanaPI_Baja vPI_baja, VentanaPI_Consulta vPI_consulta,
			VentanaPI_Edicion vPI_edicion, VentanaAlumnos_Alta vAl_alta, VentanaAlumnos_Baja vAl_baja,
			VentanaAlumnos_Consulta vAl_consulta, VentanaAlumnos_Edicion vAl_edicion, VentanaArea_Alta vAr_alta,
			VentanaArea_Baja vAr_baja, VentanaArea_Edicion vAr_edicion, VentanaAyuda vAy, VentanaPI_Asociar vpiaso) {
		super();
		VPpal = vPpal;
		VPI_alta = vPI_alta;
		VPI_baja = vPI_baja;
		VPI_consulta = vPI_consulta;
		VPI_edicion = vPI_edicion;
		VAl_alta = vAl_alta;
		VAl_baja = vAl_baja;
		VAl_consulta = vAl_consulta;
		VAl_edicion = vAl_edicion;
		VAr_alta = vAr_alta;
		VAr_baja = vAr_baja;
		VAr_edicion = vAr_edicion;
		Vay = vAy;
		this.vpiaso = vpiaso;
		
	}

	/**
	 * Implementa el método actionPerformed de la interfaz ActionListener y define el comportamiento al hacer clic en el botón.
	 * Llama a los distintos métodos de las ventanas asociadas al menú.
	 * 
	 * @param e el evento que disparó la acción
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		  if (source == VPpal.getPi_alta()) {
		        VPI_alta.hacerVisible(); // Mostrar la ventana VentanaPI_Alta
		        VPI_alta.setAreasList(acceso.conseguirAreas(con));
		        VPI_alta.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getPi_baja()) {
		        VPI_baja.hacerVisible(); // Mostrar la ventana VentanaPI_Baja
		        VPpal.dispose();
		    } else if (source == VPpal.getPi_edicion()) {
		        VPI_edicion.hacerVisible(); // Mostrar la ventana VentanaPI_Edicion
		    	VPI_edicion.setAreasList(acceso.conseguirAreas(con));
		    	VPI_edicion.getBtnGuardar().setEnabled(false);
		    	VPI_edicion.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getPi_consulta()) {
		    	VPI_consulta.hacerVisible(); // Mostrar la ventana VentanaPI_Consulta
		    	VPI_consulta.setAreasList(acceso.conseguirAreas(con));
		    	VPI_consulta.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getPi_asociar()) {
		    	vpiaso.hacerVisible(); // Mostrar la ventana VentanaPI_Consulta
		    	vpiaso.setAreasList(acceso.conseguirAreas(con));
		    	vpiaso.rellenarComboBox();
		        VPpal.dispose();
		    } 
		    
		    else if (source == VPpal.getAlumnos_alta()) {
		        VAl_alta.hacerVisible(); // Mostrar la ventana VentanaAlumnos_Alta
		        VAl_alta.setAreasList(acceso.conseguirAreas(con));
		        VAl_alta.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getAlumnos_baja()) {
		        VAl_baja.hacerVisible(); // Mostrar la ventana VentanaAlumnos_Baja
		        VPpal.dispose();
		    } else if (source == VPpal.getAlumnos_consulta()) {
		        VAl_consulta.hacerVisible(); // Mostrar la ventana VentanaAlumnos_Consulta
		        VAl_consulta.setAreasList(acceso.conseguirAreas(con));
		        VAl_consulta.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getAlumnos_edicion()) {
		        VAl_edicion.hacerVisible(); // Mostrar la ventana VentanaAlumnos_Edicion
		        VAl_edicion.setAreasList(acceso.conseguirAreas(con));
		        VAl_edicion.getBtnGuardar().setEnabled(false);
		        VAl_edicion.rellenarComboBox();
		        VPpal.dispose();
		    } else if (source == VPpal.getArea_alta()) {
		        VAr_alta.hacerVisible(); // Mostrar la ventana VentanaArea_Alta
		        VPpal.dispose();
		    } else if (source == VPpal.getArea_baja()) {
		        VAr_baja.hacerVisible(); // Mostrar la ventana VentanaArea_Baja
		        VPpal.dispose();
		    } else if (source == VPpal.getArea_edicion()) {
		        VAr_edicion.hacerVisible(); // Mostrar la ventana VentanaArea_Edicion
		        VAr_edicion.getBtnGuardar().setEnabled(false);
		        VPpal.dispose();
		    } else if (source == VPpal.getMnAyuda()) { 
		    	Vay.hacerVisible(); //Mostrar la ventana VentanaAyuda
		    	VPpal.dispose();
		    }
		  acceso.cerrarConexion();
	}
	
	
		
}
