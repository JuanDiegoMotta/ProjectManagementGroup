/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase ListenerGuardar es el listener de las ventanas de edición que se encarga de efectuar los
 * cambios pertinentes en la BBDD
 * 
 * @author PMG
 *
 */
public class ListenerGuardar implements ActionListener {
	private VentanaAlumnos_Edicion vae;
	private VentanaArea_Edicion vare;
	private VentanaPI_Edicion vpie;
	private AccesoBBDD acceso;
	
	/**
	 * Constructor de ListenerGuardar con parámetros
	 * @param vae Instancia de VentanaAlumnos_Edicion
	 * @param vare Instancia de VentanaArea_Edicion
	 * @param vpie Instancia de VentanaPI_Edicion
	 */
	public ListenerGuardar(VentanaAlumnos_Edicion vae, VentanaArea_Edicion vare, VentanaPI_Edicion vpie) {
		super();
		this.vae = vae;
		this.vare = vare;
		this.vpie = vpie;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		acceso = new AccesoBBDD();
		Connection con = acceso.getConexion();
		if(source == vare.getBtnGuardar()) { //Si es el btn de VentanaArea_Edicion
			vare.mostrarAviso(acceso.updateArea(con, vare.getTxtDescripcion().getText(), vare.getTxtNombreCorto().getText()));
		} else if (source == vae.getBtnGuardar()) {
			String nombre_ape = vae.getTxtNombre().getText();
			vae.mostrarAviso(acceso.updateAlumno(con, vae.getTxtCod().getText(), nombre_ape));
		} else if (source == vpie.getBtnGuardar()) {
			String cod_proyecto = vpie.getTxtCod().getText();
			String nombre = vpie.getTxtNombre().getText();
			String curso = String.valueOf((int) vpie.getSpnrCurso().getValue());
			String nota = String.valueOf((int) vpie.getSpnrNota().getValue());
			String ano = (String) vpie.getCmbxAno().getSelectedItem();
			String url = vpie.getTxtGit().getText();
			
			try {
				vpie.mostrarAviso(acceso.updatePI(con, cod_proyecto, nombre, curso, nota, ano, url));
			} catch (SQLIntegrityConstraintViolationException e1) {
				vpie.getLblAviso().setText("Nombre ya existe en la BBDD");
			}				
		}
		acceso.cerrarConexion();

	}

}
