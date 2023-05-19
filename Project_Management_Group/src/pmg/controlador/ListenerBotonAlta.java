/**
 * 
 */
package pmg.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pmg.vista.*;

/**
 * @author jburg
 *
 */
public class ListenerBotonAlta implements ActionListener {

	private VentanaAlumnos_Alta vala;
	private VentanaArea_Alta vara;
	private VentanaPI_Alta vpia;

	public ListenerBotonAlta(VentanaAlumnos_Alta vala, VentanaArea_Alta vara, VentanaPI_Alta vpia) {
		this.vala = vala;
		this.vara = vara;
		this.vpia = vpia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == vala.getBtnAlta()) {
			altaAlumnos();
		} else if (source == vara.getBtnAlta()) {
			altaArea();
		} else if (source == vpia.getBtnAlta()) {
			altaPI();
		}
	}
	
	public void altaAlumnos() {
		System.out.println("esto es una prueba");
	}

}
