/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase ListenerMostrar es la clase que se encarga de mostrar los datos existentes
 * sobre lo que se quiere editar
 * @author juanm
 *
 */
public class ListenerMostrar implements ActionListener {
	private VentanaAlumnos_Edicion vae;
	private VentanaArea_Edicion vare;
	private VentanaPI_Edicion vpie;
	private AccesoBBDD acceso;
	
	
	/**
	 * Constructor con parámetros de ListenerMostrar
	 * @param vae Instancia de VentanaAlumnos_Edicion
	 * @param vare Instancia de VentanaArea_Edicion
	 * @param vpie Instancia de VentanaPI_Edicion
	 */
	public ListenerMostrar(VentanaAlumnos_Edicion vae, VentanaArea_Edicion vare, VentanaPI_Edicion vpie) {
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
