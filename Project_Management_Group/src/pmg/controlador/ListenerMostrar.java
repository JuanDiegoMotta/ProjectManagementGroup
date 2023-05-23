/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import pmg.modelo.*;
import pmg.vista.*;

/**
 * Clase ListenerMostrar es la clase que se encarga de mostrar los datos
 * existentes sobre lo que se quiere editar
 * 
 * @author PMG
 *
 */
public class ListenerMostrar implements ActionListener {
	private VentanaAlumnos_Edicion vae;
	private VentanaArea_Edicion vare;
	private VentanaPI_Edicion vpie;
	private AccesoBBDD acceso;

	/**
	 * Constructor con parámetros de ListenerMostrar
	 * 
	 * @param vae  Instancia de VentanaAlumnos_Edicion
	 * @param vare Instancia de VentanaArea_Edicion
	 * @param vpie Instancia de VentanaPI_Edicion
	 */
	public ListenerMostrar(VentanaAlumnos_Edicion vae, VentanaArea_Edicion vare, VentanaPI_Edicion vpie) {
		super();
		this.vae = vae;
		this.vare = vare;
		this.vpie = vpie;
	}

	/**
	 * Método actionPerformed se encarga de realizar las operaciones
	 * correspondientes para mostrar al usuario la información de aquello que se
	 * quiera editar cuando se pulse el botón rellenar.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == vae.getBtnRellenar()) {
			// Recogemos el cód del alumno:
			String cod_alumno = vae.getTxtCod().getText();
			mostrarInfoAlumno(vae, cod_alumno);

		} else if (source == vare.getBtnRellenar()) {
			String nc_area = vare.getTxtNombreCorto().getText();
			mostrarInfoArea(vare, nc_area);
		} else if (source == vpie.getBtnRellenar()) {
			String cod = vpie.getTxtCod().getText();
			mostrarInfoPI(vpie, cod);

		}
	}

	/**
	 * Método que se encarga de recoger los datos del alumno en la base de datos y
	 * mostrarlos en los textField correspondientes
	 * 
	 * @param vae        Instancia de VentanaAlumnos_Edicion
	 * @param cod_alumno código del alumno
	 */
	public void mostrarInfoAlumno(VentanaAlumnos_Edicion vae, String cod_alumno) {
		AccesoBBDD acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if (acceso.existeCodigoAlumno(con, cod_alumno)) {
			DatosAltaAlumno datosBaja = acceso.getInfoAlumno(con, cod_alumno);
			// Mostramos el num_expediente
			vae.getTxtNumExp().setText(datosBaja.getNumExp());
			// Mostramos el nombre
			vae.getTxtNombre().setText(datosBaja.getNombreCompleto());
			// Mostramos el área
			vae.getCmbxArea().setSelectedItem(datosBaja.getArea());
			vae.getLblAviso().setText("");
			//Impedimos que el usuario pueda editar el cod del alumno seleccionado
			vae.getTxtCod().setEditable(false);

		} else {
			vae.getLblAviso().setText("El código del alumno no existe");

			// Hacemos que no se muestre nada
			vae.getTxtNumExp().setText("");
			vae.getTxtNombre().setText("");
			vae.getCmbxArea().setSelectedItem("");
		}
		acceso.cerrarConexion();
	}

	/**
	 * Método que se encarga de recoger los datos del área en la base de datos y
	 * mostrarlos en los textField correspondientes
	 * 
	 * @param vare    Instancia de VentanaArea_Edicion
	 * @param nc_area nombre corto del área
	 */
	public void mostrarInfoArea(VentanaArea_Edicion vare, String nc_area) {
		AccesoBBDD acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if (acceso.existeNombreCortoArea(con, nc_area)) {
			DatosAltaArea datosBaja = acceso.getInfoArea(con, nc_area);
			vare.getTxtDescripcion().setText(datosBaja.getDescripcion());
			vare.getLblAviso().setText("");
			//Hacemos que el nombre corto no sea editable
			vare.getTxtNombreCorto().setEditable(false);

		} else {
			vare.getLblAviso().setText("El nombre corto del área no existe");
			// Hacemos que no se muestre nada
			vare.getTxtDescripcion().setText("");
		}
		acceso.cerrarConexion();
	}

	/**
	 * Método que se encarga de recoger los datos del PI en la base de datos y
	 * mostrarlos en los textField correspondientes
	 * 
	 * @param vpie Instancia de VentanaPI_Edicion
	 * @param cod  código del proyecto
	 */
	public void mostrarInfoPI(VentanaPI_Edicion vpie, String cod) {
		AccesoBBDD acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if (acceso.existeCodigoPI(con, cod)) {
			DatosAltaPI datosBaja = acceso.getInfoPI(con, cod);
			//Mostramos los datos del PI
			vpie.getTxtNombre().setText(datosBaja.getNombre());
			vpie.getSpnrCurso().setValue(Integer.parseInt(datosBaja.getCurso()));
			vpie.getSpnrNota().setValue(Integer.parseInt(datosBaja.getNota()));
			vpie.getCmbxAno().setSelectedItem(datosBaja.getAño());
			vpie.getCmbxArea().setSelectedItem(datosBaja.getNc_area());
			vpie.getLblAviso().setText("");
			//Hacemos que algunos campos no sean editables
			vpie.getTxtCod().setEditable(false);
			vpie.getCmbxArea().setEnabled(false);

		} else {
			vpie.getLblAviso().setText("El código del proyecto no existe");
			// Hacemos que no se muestre nada
			vpie.getTxtNombre().setText("");
			vpie.getSpnrCurso().setValue(1);
			vpie.getSpnrNota().setValue(0);
			vpie.getCmbxAno().setSelectedItem(-1);
			vpie.getCmbxArea().setSelectedItem(-1);
		}
		acceso.cerrarConexion();
	}

}
