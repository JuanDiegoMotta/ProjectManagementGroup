package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.modelo.AccesoBBDD;
import pmg.vista.*;

/**
 * Clase ListenerBoton 
 * @author Pablo
 *
 */
public class ListenerBoton implements ActionListener {

	private VentanaLogIn vl;
	private VentanaPrincipal vp;
	private AccesoBBDD bd;

	/**
	 * Constructor de la clase ListenerBoton
	 * @param vl
	 * @param vp
	 */
	public ListenerBoton(VentanaLogIn vl, VentanaPrincipal vp) {
		this.vl = vl;
		this.vp = vp;
	}

	/**
	 * Método encargado de ejecutar lo que tiene dentro cuando el botón sea pulsado
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		vl.concederAcceso(vp);
		bd = new AccesoBBDD();
		bd.getConexion();
		
		
	}

}
