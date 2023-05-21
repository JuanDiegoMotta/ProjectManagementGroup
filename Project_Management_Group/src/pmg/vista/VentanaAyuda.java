/**
 * 
 */
package pmg.vista;

import java.awt.Font;

import javax.swing.*;

import pmg.controlador.ListenerBotonAtras;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

/**
 * Clase VentanaAyuda
 * 
 * @author Pablo
 *
 */
public class VentanaAyuda extends JFrame {

	private JButton atras;
	private JTextArea mensaje;
	private JTextArea mensaje1;

	/**
	 * Constructor de la clase VentanaAyuda
	 * 
	 * @param titulo Titulo de la ventana
	 */
	public VentanaAyuda(String titulo) {
		super(titulo);
		getContentPane().setBackground(Color.decode("#A9B2AC"));
		inicializarComponentes();
	}

	/**
	 * Método para inicializar los componentes de la ventana de la clase VentanaArea
	 */
	private void inicializarComponentes() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

//		Añadirmos mensaje a la ventana
		mensaje = new JTextArea("Esta aplicación se encargará de gestionar proyectos integradores (PI) de"
				+ "las distintas áreas de estudio."
				+ "Podrás dar de alta, baja y modificar tanto los PI, como los PI, como los Alumnos y las "
				+ "Áreas existentes." + "Siga las instrucciones correspondientes en cada página y rellene los"
				+ "campos tal y como se pide. Si desea consultar algún dato puede remitirse a las pestañas"
				+ "de consulta correspondientes o también puede contactar con nosotros vía email.");
		
		mensaje1 = new JTextArea("project.magagement.group@gmail.com");
		mensaje.setWrapStyleWord(true);
		mensaje.setEditable(false);
		mensaje.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mensaje.setBackground(SystemColor.control);
		mensaje.setForeground(Color.BLACK);
		mensaje.setLineWrap(true);
		mensaje.setBounds(27, 11, 526, 177);
		getContentPane().add(mensaje);

		mensaje1.setWrapStyleWord(true);
		mensaje1.setEditable(false);
		mensaje1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mensaje1.setBackground(SystemColor.control);
		mensaje1.setForeground(Color.BLACK);
		mensaje1.setLineWrap(true);
		mensaje1.setBounds(128, 208, 281, 30);
		getContentPane().add(mensaje1);
		
//		Añadimos botón atrás
		atras = new JButton("ATRÁS");
		atras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		atras.setBounds(42, 300, 120, 30);
		getContentPane().add(atras);

		setSize(600, 400);
		setLocationRelativeTo(null);
	}

	/**
	 * Método que hace visible la pantalla
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * Método encargado de agregar un controlador a la ventana
	 */
	public void setControlador(ListenerBotonAtras ba) {
		atras.addActionListener(ba);
	}

}
