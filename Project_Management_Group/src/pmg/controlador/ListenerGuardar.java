/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase ListenerGuardar es el listener de las ventanas de edición que se encarga de efectuar los
 * cambios pertinentes en la BBDD
 * @author juanm
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
		// TODO Auto-generated method stub

	}

}
